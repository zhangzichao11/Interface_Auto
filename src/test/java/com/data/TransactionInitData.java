package com.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import com.http.ContentBody.HttpJson;

/**
 * TransactionInit api data
 * @author zzc
 *
 */
public class TransactionInitData {

	static Logger log = LoggerFactory.getLogger(TransactionInitData.class);//log class

	@DataProvider(name = "TransactionInitData001")
	public static Object[][] TransactionInitData001() {

		log.info("\t 正常初始化交易");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData001", 200,// Expected result state
				getEntryJsonStr("13710872022", "16800000017", "2", "out", "PC") } };
		return objects;

	}
	
	@DataProvider(name = "TransactionInitData002")
	public static Object[][] TransactionInitData002() {

		log.info("\t 付款者手机号为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData002", 450,// Expected result state
				getEntryJsonStr("", "16800000017", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData003")
	public static Object[][] TransactionInitData003() {

		log.info("\t 收款者手机号为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData003", 450,// Expected result state
				getEntryJsonStr("13710872022", "", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData004")
	public static Object[][] TransactionInitData004() {

		log.info("\t 付款金额为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData004", 400,// Expected result state
				getEntryJsonStr("13710872022", "16800000017", "", "out", "PC") } };

		return objects;

	}

	@DataProvider(name = "TransactionInitData005")
	public static Object[][] TransactionInitData005() {

		log.info("\t 付款类型为空");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData005", 450,// Expected result state
				getEntryJsonStr("13710872022", "16800000017", "2", "", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData006")
	public static Object[][] TransactionInitData006() {

		log.info("\t 付款者手机号不存在");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData006", 404,// Expected result state
				getEntryJsonStr("13710872029", "16800000017", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData007")
	public static Object[][] TransactionInitData007() {

		log.info("\t 收款者手机号不存在");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData007", 404,// Expected result state
				getEntryJsonStr("13710872022", "16800000178", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData008")
	public static Object[][] TransactionInitData008() {

		log.info("\t 付款手机号格式不正确");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData008", 450,// Expected result state
				getEntryJsonStr("1371087202", "16800000017", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData009")
	public static Object[][] TransactionInitData009() {

		log.info("\t 收款手机号格式不正确");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData009", 450,// Expected result state
				getEntryJsonStr("13710872022", "1680000001", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData010")
	public static Object[][] TransactionInitData010() {

		log.info("\t 付款金额小数位>2位小数");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData010", 400,// Expected result state
				getEntryJsonStr("13710872022", "16800000017", "2.999", "out", "PC") } };
		
		return objects;

	}
	
	@DataProvider(name = "TransactionInitData011")
	public static Object[][] TransactionInitData011() {

		log.info("\t 付款类型不对");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData011", 450,// Expected result state
				getEntryJsonStr("13710872022", "1680000017", "2.99", "in", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData012")
	public static Object[][] TransactionInitData012() {

		log.info("\t 付款者状态未实名认证");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData012", 404,// Expected result state
				getEntryJsonStr("15833333333", "16800000017", "2", "out", "PC") } };

		return objects;

	}

	@DataProvider(name = "TransactionInitData013")
	public static Object[][] TransactionInitData013() {

		log.info("\t 收款者状态未实名认证");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData013", 404,// Expected result state
				getEntryJsonStr("13710872022", "15833333333", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData014")
	public static Object[][] TransactionInitData014() {

		log.info("\t 付款者状态为冻结");
		Object[][] objects = new Object[][] { new Object[] {
				"TransactionInitData014", 404,// Expected result state
				getEntryJsonStr("13310872025", "16800000017", "2", "out", "PC") } };

		return objects;

	}
	
	@DataProvider(name = "TransactionInitData015")
	public static Object[][] TransactionInitData015() {
	log.info("\t 正常初始化交易,但付款金额不足");
	Object[][] objects = new Object[][] { new Object[] {
			"TransactionInitData001", 200,// Expected result state
			getEntryJsonStr("13710872022", "16800000017", "99999", "out", "PC") } };
	return objects;
	
	}
	

	/**
	 * 
	 * @param sourcePhone
	 *            payer
	 * @param targetPhone
	 *            receipter
	 * @param payType
	 *            交易类型out->pay in->receipt
	 * @param channel
	 *            trading platform
	 * @return
	 */
	private static Object getEntryJsonStr(String sourcePhone,
			String targetPhone, String amount, String payType,  String channel) {
		// TODO Auto-generated method stub

		HttpJson hpJson = new HttpJson();
		hpJson.put("sourcePhone", sourcePhone);
		hpJson.put("targetPhone", targetPhone);
		hpJson.put("amount", amount);
		hpJson.put("direction", payType);
		hpJson.put("channel", channel);
		return hpJson.Data();
	}
}
