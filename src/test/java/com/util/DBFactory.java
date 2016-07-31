package com.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * 
 *         read config file that the test machine detail information, store in
 *         properties file ,which dir configure in param "os.config.path" of
 *         "Testcases.config.config.properties" file .
 * 
 *         load all os information for rt test cases
 * 
 * 
 * 
 */
public class DBFactory {
	
	private static String defaultPath = "";

	private static HashMap<String, IDB> dbservers = new HashMap<String, IDB>();

	private static Document doc;

	private static String path = "";

	public static String getPath() {
		if (path.equals("")){
			return DBConfigure.path;
		}else{
			return path;
		}
	}

	@SuppressWarnings("rawtypes")
	public static HashMap getDBServers() {
		if (dbservers.size() <= 0) {
	
			if (path == null || path.equals("")) {
				path = DBFactory.getPath() + defaultPath;
			}
			init();
		}

		return dbservers;
	}

	public static void setPath(String path) {
		DBFactory.path = path;
	}

	public static void init() {
		try {
			
			File file = new File(path);
			SAXReader reader = new SAXReader();//解析xml
			doc = reader.read(file);
			loadOsInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * read config file get current test env os info
	 */
	public static void loadOsInfo() {

		Element root = doc.getRootElement();
		Iterator<?> it = root.elementIterator("dbserver");

		while (it.hasNext()) {

			Element dbserver = (Element) it.next();

			String tag_name = dbserver.attributeValue("name");
			String db_type = dbserver.attributeValue("type");
			String db_os = dbserver.attributeValue("os");
			String db_ip = dbserver.attributeValue("ip");
			String db_port = dbserver.attributeValue("port");
			String db_username = dbserver.attributeValue("username");
			String db_password = dbserver.attributeValue("password");
			String db_name = dbserver.attributeValue("dbName");
			String db_Instance = dbserver.attributeValue("dbInstance");

			IDB dbInst = DBFactory.newInstance(db_type);//根据类型初始化数据库连接
	
			dbInst.setDbType(db_type);
			dbInst.setDbHost(db_ip);
			dbInst.setOs(db_os);
			dbInst.setDbUser(db_username);
			dbInst.setDbPwd(db_password);
			dbInst.setDbPort(Integer.parseInt(db_port));
			dbInst.setDbInstance(db_Instance);

			if (db_name != null && !db_name.equals("")) {
				dbInst.setDbName(db_name);
			}
			
			dbservers.put(tag_name, dbInst);

		}
	}

	/**
	 * 初始化数据库连接
	 * @param dbtype
	 * @return
	 */
	public static IDB newInstance(String dbtype) {
	
		if (dbtype.equals("MYSQL")) {
			
			return new MySqlImpl();
		}

		return null;

	}
	
	/**
	 * 初始化tagName,如果不为空进行关闭
	 * @param tagName
	 * @return
	 */
	public static IDB getInstance(String tagName) {
		
		IDB dbImpl =(IDB) getDBServers().get(tagName);
		if (dbImpl != null) {

			return dbImpl.cloneDB();
		}
		return null;		
	}

}
