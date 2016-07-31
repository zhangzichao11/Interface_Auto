package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;


public abstract class DBConAbstract implements IDBCon {
	Logger log = Logger.getLogger(this.getClass());
	protected IDB db;

	public IDB getDb() {
		return db;
	}

	public void setDb(IDB db) {
		this.db = db;
	}

	public DBConAbstract() {

	}

	public DBConAbstract(IDB db) {
		this.db = db;

	}

	@SuppressWarnings("finally")
	public int execute(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		int flag = 0;
		try {
			con = getConnection();
			stmt = con.createStatement();			
			flag = stmt.executeUpdate(sql);
			log.info(">> Num : " + flag +", Sql : " + sql);
			return flag;
		} catch (Exception e) {			
			log.error(e);
			flag = 0;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					log.error(e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					log.error(e1);
				}
			}
			return flag;
		}

	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Properties properties = new Properties(); // Create Properties object
			properties.put("user", db.getDbUser()); // Set user ID for connection
			properties.put("password", db.getDbPwd());
			con = DriverManager.getConnection(db.getUrl(), properties);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;
	}

	/**
	 * get ResultMap
	 */
	public ResultMap select(String sql) throws SQLException {

		List<Map<String, String>> rsl = new LinkedList<Map<String, String>>();
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			con = getConnection();
			stmt = con.createStatement();			
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, String> hm = new LinkedHashMap<String, String>();
				for (int i = 1; i <= count; i++) {
					String key = rsmd.getColumnLabel(i);
					String value;
					value = rs.getString(i);
					hm.put(key, value);
				}
				rsl.add(hm);
			}			
			log.info(">> Num : " + rsl.size() +", Sql : " + sql);			
			return (new ResultMap(rsl));
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

}
