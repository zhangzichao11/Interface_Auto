package com.util;

import org.apache.log4j.Logger;

/**
 *         this class is the defalult implements of IDB interface.
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class DBImpl implements IDB {
	Logger log = Logger.getLogger(this.getClass());

	public static final String LOCAL_DB_USER = "";

	public static final String LOCAL_DB_PWD = "";

	public static final String REMOTE_DB_USER = "";

	public static final String REMOTE_DB_PWD = "";

	public static final String DEF_DB_NAME = "tsdata";

	public static final int DEF_DB_PORT = 50000;

	public static final int DEF_SQL_SERVER_PORT = 1433;

	private static final String DEF_DB_TYPE = "";

	public static final String DEF_DB_HOST = "localhost";

	public static final String DEF_INSTNACE_NAME = "";

	private String dbUser;

	private String dbPwd;

	private int dbPort = -1;

	private String dbHost;

	private String dbName;

	private String scriptName;

	private String os;

	private String dbType;

	private String dbInstance;

	protected DBImpl clone;

	public String getUrl() {
		return null;
	}

	/**
	 * @return Returns the os.
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os
	 *            The os to set.
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return Returns the dbHost.
	 */
	public String getDbHost() {
		return dbHost;
	}

	/**
	 * @param dbHost
	 *            The dbHost to set.
	 */
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	/**
	 * @return Returns the dbName.
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName
	 *            The dbName to set.
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return Returns the dbPort.
	 */
	public int getDbPort() {
		return dbPort;
	}

	/**
	 * @param dbPort
	 *            The dbPort to set.
	 */

	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}
	
	/**
	 * 
	 * @param dbType
	 * @return
	 */
	public String getDbType() {
		return dbType;
	}
	
	// Added by dongm
	/**
	 * @param dbType
	 *            The dbType to set.
	 */

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Library.Utility.SystemResource.DB.DBI#getDBType()
	 */
	public String getDBType() {
		if (dbType != null && !dbType.equals("")) {
			return dbType;
		}
		return DEF_DB_TYPE;
	}

	// Added end

	/*
	 * (non-Javadoc)
	 * 
	 * @see Library.Utility.SystemResource.DB.DBI#getDBHost()
	 */
	public String getDBHost() {
		if (dbHost != null && !dbHost.equals("")) {
			return this.getDbHost();
		}
		return DEF_DB_HOST;

	}

	/**
	 * @return Returns the dbPwd.
	 */
	public String getDbPwd() {
		return dbPwd;
	}

	/**
	 * @param dbPwd
	 *            The dbPwd to set.
	 */
	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}

	/**
	 * @return Returns the dbUser.
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * @param dbUser
	 *            The dbUser to set.
	 */
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	/**
	 * @return Returns the scriptName.
	 */
	public String getScriptName() {
		return scriptName;
	}

	/**
	 * @param scriptName
	 *            The scriptName to set.
	 */
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Library.Utility.SystemResource.DB.DBI#getDBPwd(int)
	 */
	public String getDBPwd() {

		if (this.getDbPwd() != null && !this.getDbPwd().equals("")) {
			return this.getDbPwd();
		}
		return LOCAL_DB_PWD;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Library.Utility.SystemResource.DB.DBI#getDBUser(int)
	 */
	public String getDBUser() {
		if (this.getDbUser() != null && !this.getDbUser().equals("")) {
			return this.getDbUser();
		}
		return LOCAL_DB_USER;

	}

	public IDBCon getCon() {
		IDBCon con = null;

		try {

			con = DBConFactory.getInstance(this);

		} catch (Exception e) {
			log.warn("", e);
			e.printStackTrace();
		}
		
		log.info(this.toString());
		return con;

		// os.get
	}

	// Added end

	/*
	 * (non-Javadoc)
	 * 
	 * @see Library.Utility.SystemResource.DB.DBI#getDBName()
	 */
	public String getDBName() {
		if (this.getDbName() != null && !this.getDbName().equals("")) {
			return this.getDbName();
		}
		return DEF_DB_NAME;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Library.Utility.SystemResource.DB.DBI#getDBPort()
	 */
	public int getDBPort() {
		if (this.getDbPort() != -1) {
			return this.getDbPort();
		}

		return DEF_DB_PORT;

	}

	public IDB cloneDB() {
		try {
			clone = (DBImpl) (this.getClass().newInstance());
		} catch (Exception e) {
		}
		if (clone == null) {
			clone = new DBImpl();
		}
		clone.setDbHost(dbHost);
		clone.setDbName(getDBName());
		clone.setDbPort(getDBPort());
		clone.setDbPwd(dbPwd);
		clone.setDbUser(dbUser);
		clone.setScriptName(this.getScriptName());
		clone.setDbType(this.getDbType());
		clone.setOs(this.getOs());

		return clone;
		//
	}

	public String toString() {
		String result = "";
		result = "dbHost:" + dbHost + "," + "dbPort:" + getDBPort() + "," + "os:" + os + "," + "type:" + dbType + ","
				+ "dbUser:" + dbUser + "," + "dbPwd:" + dbPwd + "," + "dbName:" + getDBName() + ",dbInstance:"
				+ getDbInstance();
		return result;
	}

	public String getDbInstance() {
		// TODO Auto-generated method stub
		if (dbInstance != null && !dbInstance.equals("")) {
			return dbInstance;
		}
		return DEF_INSTNACE_NAME;
	}

	public void setDbInstance(String dbInstance) {
		// TODO Auto-generated method stub
		this.dbInstance = dbInstance;
	}
	

}