package com.acinterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.http.AWebApiService;
import com.http.ContentBody.HttpJson;
import com.http.Request.HttpRequest;

import common.GetProperties;

public class IDfbTransactionCreate extends AWebApiService{
	public int expStatus;
	static Logger log=LoggerFactory.getLogger(IDfbTransactionInit.class);
	GetProperties gp=new GetProperties();

	public IDfbTransactionCreate(int expStatus){
		
		HttpJson hpJson = new HttpJson();
		
		domain=gp.getBaseUrl();//read public api url
		url=gp.getTransactionCreateUrl();//read transCreate url
		method = HttpRequest.METHOD_POST;//Request mode is post
		header.put("Content-Type", HttpRequest.CONTENT_TYPE_JSON);//quest para type
		header.put(HttpRequest.HEADER_AUTHORIZATION, "Bearer "+ gp.getToken());//get token
		
		hpJson.setStreamCharset("UTF-8");
		contentRequest = hpJson;
		this.expStatus=expStatus;
	}
	
	@Override
	public void beforeRequest() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterRequest() throws Exception {
		// TODO Auto-generated method stub
		log.info("Response Header :{}", contentResponse.getHeaders().getData());
		log.info("Response Content :{}", contentResponse.getContent());
		Assert.assertEquals(contentResponse.getStatus(), expStatus);// check status
	}

}
