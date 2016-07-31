package com.suite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.acinterface.IDfbTransactionCreate;
import com.data.TransactionCreateData;

import common.BaseCase;
import common.JsonEntity;

public class CaseTransactionCreate extends BaseCase{
	
	static Logger log = LoggerFactory.getLogger(CaseTransactionCreate.class);
		// 交易创建--正常的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate001" }, dataProvider = "TransactionCreateData001", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate001(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate001] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		// 交易创建--交易id为空的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate002" }, dataProvider = "TransactionCreateData002", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate002(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate002] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		// 交易创建--付款账户信息为空的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate003" }, dataProvider = "TransactionCreateData003", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate003(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate003] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		// 交易创建--付款总额为空的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate004" }, dataProvider = "TransactionCreateData004", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate004(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate004] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		// 交易创建--错误的交易id的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate005" }, dataProvider = "TransactionCreateData005", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate005(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate005] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		// 交易创建--付款账户金额与初始化金额不一致的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate006" }, dataProvider = "TransactionCreateData006", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate006(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate006] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		// 交易创建--交易总额与初始化金额不一致的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate007" }, dataProvider = "TransactionCreateData007", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate007(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate007] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		// 交易创建--付款金额不足的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate008" }, dataProvider = "TransactionCreateData008", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate008(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate008] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}
		
		
		// 交易创建--json参数为空的测试用例
		@Test(enabled = true, groups = { "CaseTransactionCreate009" }, dataProvider = "TransactionCreateData009", dataProviderClass = TransactionCreateData.class)
		public void CaseTransactionCreate009(String dataName, int expStatus,
				String JsonStr) throws Exception {
			log.info(
					"\t[ CaseTransactionCreate009] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
					dataName, expStatus, JsonStr);
			IDfbTransactionCreate tranCreate = new IDfbTransactionCreate(expStatus);
			tranCreate.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
			tranCreate.run();

		}


}
