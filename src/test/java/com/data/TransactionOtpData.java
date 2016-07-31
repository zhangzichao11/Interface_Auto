package com.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import com.http.ContentBody.HttpJson;
import common.GetProperties;

public class TransactionOtpData {
	
	static Logger log = LoggerFactory.getLogger(TransactionOtpData.class);
	 static GetProperties gp=new GetProperties();//读取公共配置文件的类
	 
	@DataProvider(name = "TransactionOtpData001")
	public static Object[][] TransactionOtpData001() {

		log.info("\t 正常获取OTP");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionOtpData001", 201,
				getEntryJsonStr(gp.getTransactionId()) } };
		return objects;

	}
	
	/**
	 * 
	 * @param transactionId 交易id
	 * @param royalty_paramet 付款类型
	 * @param totalAmount  付款金额
	 * @return json
	 */
	private static Object getEntryJsonStr(String transactionId) {
		// TODO Auto-generated method stub

		HttpJson hpJson = new HttpJson();
		hpJson.put("transaction", transactionId);
		return hpJson.Data();
	}
}
