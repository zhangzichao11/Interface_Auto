package com.acinterface;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.http.AWebApiService;
import com.http.ContentBody.HttpJson;
import com.http.Request.HttpRequest;

import common.GetProperties;

public class IDfbTransactionInit extends AWebApiService {

	public int expStatus;
	public static String transactionId;
	static Logger log = LoggerFactory.getLogger(IDfbTransactionInit.class);
	GetProperties gp = new GetProperties();
	
	/**
	 * interface set
	 * @param expStatus
	 */
	public IDfbTransactionInit(int expStatus) {
		// TODO Auto-generated constructor stub
		HttpJson hpJson = new HttpJson();

		domain = gp.getBaseUrl();// read public api url
		url = gp.getTransactionInitUrl();// read transInit url
		method = HttpRequest.METHOD_POST;// Request mode is post
		header.put("Content-Type", HttpRequest.CONTENT_TYPE_JSON);// quest para type
		header.put(HttpRequest.HEADER_AUTHORIZATION, "Bearer " + gp.getToken());// logned token
		hpJson.setStreamCharset("UTF-8");
		contentRequest = hpJson;
		this.expStatus = expStatus;
	}

	@Override
	public void beforeRequest() throws Exception {
		// TODO Auto-generated method stub

	}
	
	/**
	 * get interface respone content
	 */
	@Override
	public void afterRequest() throws Exception {
		// TODO Auto-generated method stub
		log.info("Response Header :{}", contentResponse.getHeaders().getData());
		log.info("Response Content :{}", contentResponse.getContent());
		Assert.assertEquals(contentResponse.getStatus(), expStatus);// check status

		String transactionId = contentResponse.getContent();// get resopne content
		boolean isInitInfo = JSONObject.fromObject(transactionId).containsKey("txInitInfo");// is exist txInitInfo
		if (isInitInfo) {

			JSONObject json = JSONObject.fromObject(transactionId).getJSONObject("txInitInfo"); // get txInitInfo to json
			boolean isTransactionId = json.containsKey("transactionId");// To judge whether the transaction exists
			if (isTransactionId) {

				transactionId = json.get("transactionId").toString();// get transactionId
				gp.setTransactionId(transactionId);//save transactionId to transactionCreate
				log.info("transactionId-->>" + transactionId);
			} else {

				log.info("transactionId is not exist");
			}
		}

	}

}
