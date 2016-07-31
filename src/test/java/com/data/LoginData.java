package com.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import com.http.ContentBody.HttpJson;

public class LoginData {

	static Logger log = LoggerFactory.getLogger(LoginData.class);
	private static String userName = "13710872022";
	private static String userPwd = "che001";

	@DataProvider(name = "LoginData001")
	public static Object[][] loginData001() {

		log.info("\t 登录-正常测试用例");
		Object[][] objects = new Object[][] { new Object[] {
				"LoginData001",
				userName,//login name
				userPwd,//login pwd
				200,// Expected result state
				getEntryJsonStr("ANDROID", "120c83f7602791d0bef",
						"866696027120060", "HUAWEIHUAWEI GRA-UL00") } };//quest parameter 
		return objects;

	}

	@DataProvider(name = "LoginData002")
	public static Object[][] loginData002() {

		log.info("\t 登录-其中deviceId为空的测试用例");
		Object[][] objects1 = new Object[][] { new Object[] {
				"LoginData002",
				userName,//login name
				userPwd,//login pwd
				400,//Expected result state
				getEntryJsonStr("ANDROID", "", "866696027120060",
						"HUAWEIHUAWEI GRA-UL00") } };//quest parameter 
		return objects1;

	}

	/**
	 * 把字符串转为json数据
	 * 
	 * @param platform
	 * @param deviceId
	 * @param mobileId
	 * @param deviceName
	 * @return cc.Data()
	 */
	private static Object getEntryJsonStr(String platform, String deviceId,
			String mobileId, String deviceName) {
		// TODO Auto-generated method stub

		HttpJson hpJson = new HttpJson();
		hpJson.put("platform", platform);
		hpJson.put("deviceId", deviceId);
		hpJson.put("mobileId", mobileId);
		hpJson.put("deviceName", deviceName);
		return hpJson.Data();
	}

}
