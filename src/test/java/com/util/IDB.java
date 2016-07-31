package com.util;

/**
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public interface IDB {

	public String getDbUser();

	public String getUrl();

	public String getDbPwd();

	public String getDbName();

	public String getDbInstance();

	public String getDbHost();

	public int getDbPort();

	public IDBCon getCon();

	public String getOs();

	public String getDbType();

	public void setDbHost(String dbHost);

	public void setDbName(String dbName);

	public void setDbPort(int dbPort);

	public void setDbUser(String dbUser);

	public void setDbPwd(String dbPwd);

	public void setDbInstance(String dbInstance);

	public void setDbType(String dbType);

	public void setOs(String os);

	public IDB cloneDB();
}