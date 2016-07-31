package com.suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.acinterface.IDfbLogin;
import com.data.LoginData;

import common.BaseCase;
import common.JsonEntity;

/**
 * 登录接口的case
 * 
 * @author zzc
 *
 */
public class CaseLogin extends BaseCase {

	static Logger log = LoggerFactory.getLogger(CaseLogin.class);

	//正常登陆的case
	@Test(enabled = true, groups = { "CaseLogin001" }, dataProvider = "LoginData001", dataProviderClass = LoginData.class)
	public void CaseLogin001(String dataName, String userName,
			String userPwd, int expStatus, String JsonStr) throws Exception {

		log.info(
				"\t[ CaseLogin001] DATA NAME:{}, UserName:{}, UserPwd:{},  Exp HttpStatus:{}, \n\tParam:{}\n",
				dataName, userName, userPwd, expStatus, JsonStr);
		IDfbLogin login001 = new IDfbLogin(userName, userPwd, expStatus);
		login001.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		login001.run();
	}
	
	//登录时其中deviceId为空的测试用例
	@Test(enabled = true, groups = { "CaseLogin002" }, dataProvider = "LoginData002", dataProviderClass = LoginData.class)
	public void CaseLogin002(String dataName, String userName,
			String userPwd, int expStatus, String JsonStr) throws Exception {

		log.info(
				"\t[ CaseLogin002 exception] DATA NAME:{}, Exp HttpStatus:{}, UserName:{}, UserPwd:{}, \n\tParam:{}\n",
				dataName, userName, userPwd, expStatus, JsonStr);
		IDfbLogin login002 = new IDfbLogin(userName, userPwd, expStatus);
		login002.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		login002.run();

	}


}
