package com.data;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import com.http.ContentBody.HttpJson;
import com.util.IDBCon;
import com.util.ResultMap;

import common.BaseCase;
import common.GetProperties;

public class TransactionApproveData {
	
	static Logger log = LoggerFactory.getLogger(TransactionCreateData.class);
	static GetProperties gp=new GetProperties();//读取公共配置文件的类
	private static String otp;
	static IDBCon dfbDb = BaseCase.db.getCon(); 
	static String getOtp="select OtpCode from OTP where PlatTransGuid='"+ gp.getTransactionId() + "'" + " limit 1";
	@DataProvider(name = "TransactionApproveData001")
	public static Object[][] TransactionApproveData001() {
		
		try {
			
			log.info("mysql语句:"+getOtp);
			ResultMap otp1= dfbDb.select(getOtp);//通过该语句从数据库中获取otp
			otp=otp1.getKey("OtpCode");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("\t 交易正常确认");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionApproveData001", 201,
				getEntryJsonStr(gp.getTransactionId(),otp) } };
		return objects;

	}
	
	/**
	 * 
	 * @param transactionId 交易id
	 * @param royalty_paramet 付款类型
	 * @param totalAmount  付款金额
	 * @return json
	 */
	private static Object getEntryJsonStr(String transactionId,String otp) {
		// TODO Auto-generated method stub

		HttpJson hpJson = new HttpJson();
		hpJson.put("transactionId", transactionId);
		hpJson.put("otp", otp);

		return hpJson.Data();
	}
}
