package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySqlcon extends DBConAbstract {
	static {
		try {

			// Load the Mysql driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("exception is " + e);
			e.printStackTrace();
		}
	}

	public MySqlcon() {
		super();
	}

	public MySqlcon(IDB db) {
		super(db);
	}

	// @Override
	@SuppressWarnings("unchecked")
	public String[] listTables(String schema) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		String[] tables = null;

		try {
			con = getConnection();
			stmt = con.createStatement();

			String sql = "select name from sysibm.systables where type='T' and creator='" + schema + "' order by name";
			rs = stmt.executeQuery(sql);

			// put result into an ArrayList
			@SuppressWarnings("rawtypes")
			ArrayList list = new ArrayList();
			while (rs.next())
				list.add(rs.getObject(1));
			// convert result from ArrayList to String array
			tables = new String[list.size()];
			for (int i = 0; i < list.size(); i++)
				tables[i] = (String) list.get(i);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return tables;
	}
}