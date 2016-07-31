package com.suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.acinterface.IDfbTransactionApprove;
import com.data.TransactionApproveData;




import common.BaseCase;
import common.JsonEntity;

public class CaseTransactionApprove extends BaseCase{
	
	static Logger log = LoggerFactory.getLogger(CaseTransactionApprove.class);
	//交易确认--正常的交易确认测试用例
	@Test(enabled = true, groups = { "CaseTransactionApprove001" }, dataProvider = "TransactionApproveData001", dataProviderClass = TransactionApproveData.class)
	public void CaseTransactionApprove001(String dataName, int expStatus,
			String JsonStr) throws Exception {
		log.info(
				"\t[ CaseTransactionApprove001] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				dataName, expStatus, JsonStr);
		IDfbTransactionApprove tranApprove = new IDfbTransactionApprove(expStatus);
		tranApprove.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranApprove.run();

	}
}
