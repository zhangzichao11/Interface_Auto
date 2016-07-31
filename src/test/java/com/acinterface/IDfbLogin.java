package com.acinterface;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.http.AWebApiService;
import com.http.ContentBody.HttpJson;
import com.http.Request.HttpRequest;
import common.GetProperties;
import common.Encrypt.Base.Base64;

/**
 * 移动登录接口
 * 
 * @author zzc
 *
 */
public class IDfbLogin extends AWebApiService {

	static Logger log = LoggerFactory.getLogger(IDfbLogin.class);
	public int expStatus;
	private String token;
    GetProperties gp=new GetProperties();//读取公共配置文件的类
    
	public IDfbLogin(String userName, String userPwd,int expStatus) {
		
		
			HttpJson hpJson = new HttpJson();
		
			domain=gp.getBaseUrl();//读取api的公共url
			url=gp.getLoginUrl();//read login url
			method = HttpRequest.METHOD_POST;//Request mode is post
			header.put("Content-Type", HttpRequest.CONTENT_TYPE_JSON);//请求参数类型
			String login = userName + ":" + userPwd;
			String base64login = new String(Base64.encode(login));//通过base64给登录信息加密
			header.put(HttpRequest.HEADER_AUTHORIZATION, "Basic " + base64login);
			hpJson.setStreamCharset("UTF-8");
			contentRequest = hpJson;
			this.expStatus=expStatus;

	}
	
	public void beforeRequest() throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterRequest() throws Exception {
		// TODO Auto-generated method stub
		log.info("Response Header :{}", contentResponse.getHeaders().getData());
		log.info("Response Content :{}", contentResponse.getContent());
		Assert.assertEquals(contentResponse.getStatus(), expStatus);//check status
		token=contentResponse.getContent();
		JSONObject json = JSONObject.fromObject(token);  //string to json
		boolean istoken=json.containsKey("access_token");//If there is token on the output
		if(istoken){
			
			token=json.get("access_token").toString();
			gp.setToken(token);
			log.info("token-->>"+token);
		}
		

	}

}
