package com.suite;

/**
 * 交易初始化接口
 * 针对收付款方手机号、安全码、付款方式（in/out）的非空校验，只有在收款方发起的交易才会校验付款方安全码
 *首先校验付款方信息，根据手机号查询付款方serviceAccount的存在性
 *然后根据userId查询user并判断用户状态是否可交易
 *其次判断如果是个人用户则进行实名认证判断，企业用户则查询企业数据是否存在
 *最后根据userId查询出付款方Account与Card并判断其当前是否处于可交易状态，现在Account表状态分为人工与系统两个状态字段，
 *必须保证这两个字段在正常与冻结收款两个状态中才可以交易
 *收款方的判断只在Card与Account上与付款方有区别，收款方的Account必须保证状态为正常、冻结付款、还款中其中一个，Card保证为正常与冻结付款之一
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.acinterface.IDfbTransactionInit;
import com.data.TransactionInitData;

import common.BaseCase;
import common.JsonEntity;

public class CaseTransactionInit extends BaseCase {

	static Logger log = LoggerFactory.getLogger(CaseTransactionInit.class);

	// 交易初始化正常的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit001" }, dataProvider = "TransactionInitData001", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit001(String caseName, int expStatus,
			String JsonStr) throws Exception {
		log.info(
				"\t[ CaseTransactionInit001] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();

	}

	// 交易初始化,付款者手机号为空的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit002" }, dataProvider = "TransactionInitData002", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit002(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit002] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,收款者手机号为空的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit003" }, dataProvider = "TransactionInitData003", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit003(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit003] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款金额为空的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit004" }, dataProvider = "TransactionInitData004", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit004(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit004] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款类型为空的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit005" }, dataProvider = "TransactionInitData005", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit005(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit005] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款者手机号不存在的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit006" }, dataProvider = "TransactionInitData006", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit006(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit006] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,收款者手机号不存在的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit007" }, dataProvider = "TransactionInitData007", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit007(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit007] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款者手机号不正确的试用例
	@Test(enabled = true, groups = { "CaseTransactionInit008" }, dataProvider = "TransactionInitData008", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit008(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit008] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,收款者手机号不正确的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit009" }, dataProvider = "TransactionInitData009", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit009(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit009] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款金额小数位数>2的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit010" }, dataProvider = "TransactionInitData010", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit010(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit010] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款类型不对的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit011" }, dataProvider = "TransactionInitData011", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit011(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit011] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款者未实名认证的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit012" }, dataProvider = "TransactionInitData012", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit012(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit012] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,收款者未实名认证的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit013" }, dataProvider = "TransactionInitData013", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit013(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit013] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

	// 交易初始化,付款者状态为冻结的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit014" }, dataProvider = "TransactionInitData014", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit014(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit014] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}
	
	// 交易初始化,付款金额不足的测试用例
	@Test(enabled = true, groups = { "CaseTransactionInit015" }, dataProvider = "TransactionInitData015", dataProviderClass = TransactionInitData.class)
	public void CaseTransactionInit015(String caseName, int expStatus,
			String JsonStr) throws Exception {

		log.info(
				"\t[ CaseTransactionInit015] DATA NAME:{}, Exp HttpStatus:{}, \n\tParam:{}\n",
				caseName, expStatus, JsonStr);
		IDfbTransactionInit tranInit = new IDfbTransactionInit(expStatus);
		tranInit.contentRequest.init(JsonEntity.JsonToMap(JsonStr));
		tranInit.run();
	}

}
