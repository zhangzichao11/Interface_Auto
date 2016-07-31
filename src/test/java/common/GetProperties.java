package common;

/**
 * api自动化,读取配置文件的公共类
 * 
 * @author zzc
 *
 */
public class GetProperties {

	static PropertyFile pf = new PropertyFile("conf/env.properties");// 读取配置文件
	private String baseurl;// 读取环境的url
	private String loginUrl;// 登录api的url
	private String transInitUrl;// 交易初始化url
	private String transCreateUrl;// 交易创建的url
	private String transOtpUrl;// 交易otp的url
	private String transApproveUrl;
	private String dbTag;// 连接数据库的标签
	public static String token;// 登录时的token
	private static String transactionId;// 交易id

	/**
	 * 获取api的baseUrl
	 * 
	 * @return baseurl
	 */
	public String getBaseUrl() {

		baseurl = pf.getValue("baseUri");

		return baseurl;
	}

	/**
	 * 获取登录的Url
	 * 
	 * @return loginUrl
	 */
	public String getLoginUrl() {

		loginUrl = pf.getValue("loginUrl");

		return loginUrl;
	}

	/**
	 * 获取交易初始化的Url
	 * 
	 * @return transInitUrl
	 */
	public String getTransactionInitUrl() {

		transInitUrl = pf.getValue("TransactionInitUrl");
		return transInitUrl;
	}

	/**
	 * 获取交易创建的Url
	 * 
	 * @return transCreateUrl
	 */
	public String getTransactionCreateUrl() {

		transCreateUrl = pf.getValue("TransactionCreateUrl");
		return transCreateUrl;
	}
	
	/**
	 * 获取OTP的url
	 * @return
	 */
	public String getTransactionOtpUrl() {

		 transOtpUrl = pf.getValue("TransactionOtpUrl");
		 return transOtpUrl;
	}

	public String getTransactionApproveUrl(){
		
		transApproveUrl=pf.getValue("TransactionApproveUrl");
		return transApproveUrl;
	}
	
	/**
	 * 连接数据库的标签
	 * 
	 * @return dbTag
	 */
	public String getDbTag() {

		dbTag = pf.getValue("dbTag");
		return dbTag;
	}

	/**
	 * 登录后的token
	 * 
	 * @return token
	 */
	public String getToken() {
		return token;
	}

	@SuppressWarnings("static-access")
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 交易id
	 * 
	 * @return transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	@SuppressWarnings("static-access")
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}