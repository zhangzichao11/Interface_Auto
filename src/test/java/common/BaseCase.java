package common;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.util.DBConfigure;
import com.util.DBFactory;
import com.util.IDB;
import com.util.IDBCon;

import common.FileOperation;
import common.GetProperties;

/**
 * 基类，方法运行前后的一些基础设置
 * @author zzc
 *
 */
public class BaseCase {
	
	static Logger log = LoggerFactory.getLogger(BaseCase.class);//打印日志
	FileOperation fp=new FileOperation();//文件处理类
	GetProperties gp=new GetProperties();//公共变量类
	
	public static IDB db = null;
	public static IDB q_db = null;
	public static IDBCon accountDb = null;
	protected IDBCon accDb = null;
	
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Exception {
		
		log.info("■■■■■■■■■■■■*Test Method*■■■■■■■■■■■■");
	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod() throws Exception {
		log.info("■■■■■■■■■■■■*End Test Method*■■■■■■■■■■■■");
	}

	@BeforeClass(alwaysRun=true)
	public void beforeClass() throws Exception {
		
		String dbconfigpath = fp.getPath()+"conf/dbservers.xml";
		String  log4jfilepath= fp.getPath()+"conf/log4j.properties";
		PropertyConfigurator.configure(log4jfilepath);//解析并配置log
		DBConfigure.configure(dbconfigpath);//配置db的xml路径
		db = DBFactory.getInstance(gp.getDbTag());//根据配置文件里面的dbTab进行初始化
		accountDb = db.getCon();
		
		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

	}

	@AfterClass(alwaysRun=true)
	public void afterClass() throws Exception {
		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
}
