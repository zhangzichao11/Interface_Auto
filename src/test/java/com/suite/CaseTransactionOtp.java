package com.suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.acinterface.IDfbTransactionOtp;
import com.data.TransactionOtpData;

import common.BaseCase;
import common.JsonEntity;

public class CaseTransactionOtp extends BaseCase{
	
	static Logger log = LoggerFactory.getLogger(CaseTransactionCreate.class);
	//获取OTP--正常的测试用例
	@Test(enabled = true, groups = { "CaseTransactionOtp001" }, dataProvider = "TransactionOtpData001", dataProviderClass = TransactionOtpData.class)
	public void CaseTransactionOtp001(String dataName, int expStatus,
			String JsonStr) throws Exception {
		log.info(
				"\t[ CaseTransactionOtp001] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				dataName, expStatus, JsonStr);
		IDfbTransactionOtp tranOTP = new IDfbTransactionOtp(expStatus);
		tranOTP.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranOTP.run();

	}
}
