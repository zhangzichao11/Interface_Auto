package com.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import com.http.ContentBody.HttpJson;
import common.GetProperties;

public class TransactionCreateData {

	static Logger log = LoggerFactory.getLogger(TransactionCreateData.class);
	 static GetProperties gp=new GetProperties();//读取公共配置文件的类
	 
	@DataProvider(name = "TransactionCreateData001")
	public static Object[][] TransatcionCreateData001() {

		log.info("\t 正常交易创建");
		Object[][] objects = new Object[][] { new Object[] {
				"TransatcionCreateData001", 201,
				getEntryJsonStr(gp.getTransactionId(), "AF_2&&CF_0", "2") } };
		return objects;

	}
	
	
	@DataProvider(name = "TransactionCreateData002")
	public static Object[][] TransatcionCreateData002() {

		log.info("\t 交易id为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransatcionCreateData002", 450,
				getEntryJsonStr("", "AF_2&&CF_0", "2") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionCreateData003")
	public static Object[][] TransactionCreateData003() {

		log.info("\t 付款账户信息为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionCreateData003", 450,
				getEntryJsonStr(gp.getTransactionId(), "", "2") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionCreateData004")
	public static Object[][] TransactionCreateData004() {

		log.info("\t 交易总额为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionCreateData004", 400,
				getEntryJsonStr(gp.getTransactionId(), "AF_2&&CF_0", "") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionCreateData005")
	public static Object[][] TransatcionCreateData005() {

		log.info("\t 错误的交易id");
		Object[][] objects = new Object[][] { new Object[] {
				"TransatcionCreateData005", 404,
				getEntryJsonStr(gp.getTransactionId()+"1", "AF_2&&CF_0", "2") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionCreateData006")
	public static Object[][] TransactionCreateData006() {

		log.info("\t 错误的付款账户信息，和初始化金额不一致");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionCreateData006", 450,
				getEntryJsonStr(gp.getTransactionId(), "AF_1&&CF_0", "2") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionCreateData007")
	public static Object[][] TransactionCreateData007() {

		log.info("\t 错误的交易总额信息，和初始化金额不一致");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionCreateData007", 450,
				getEntryJsonStr(gp.getTransactionId(), "AF_2&&CF_0", "3") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionCreateData008")
	public static Object[][] TransatcionCreateData008() {

		log.info("\t 付款金额不足");
		Object[][] objects = new Object[][] { new Object[] {
				"TransatcionCreateData008", 412,
				getEntryJsonStr(gp.getTransactionId(), "AF_99999&&CF_0", "99999") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionCreateData009")
	public static Object[][] TransatcionCreateData009() {

		log.info("\t json参数为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransatcionCreateData009", 400,
				getEntryJsonStr("","","") } };
		return objects;

	}


	/**
	 * 
	 * @param transactionId 交易id
	 * @param royalty_paramet 付款类型
	 * @param totalAmount  付款金额
	 * @return json
	 */
	private static Object getEntryJsonStr(String transactionId,
			String royalty_paramet, String totalAmount) {
		// TODO Auto-generated method stub

		HttpJson hpJson = new HttpJson();
		hpJson.put("transactionId", transactionId);
		hpJson.put("royalty_paramet", royalty_paramet);
		hpJson.put("totalAmount", totalAmount);

		return hpJson.Data();
	}

}
