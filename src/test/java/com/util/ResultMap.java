package com.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ResultMap {

	Logger log = Logger.getLogger(this.getClass());
	List<Map<String, String>> lm = new LinkedList<Map<String, String>>();;

	
	public ResultMap() {

	}
	
	public List<Map<String, String>> getLM(){
		return lm;
	}

	public String getKey(String key){
		return lm.get(0).get(key);
	}
	
	public ResultMap(List<Map<String, String>> lm) {
		this.lm = lm;
	}

	public Map<String, String> index(int i) {
		return lm.get(i);
	}

	public int size() {
		if (lm == null) {
			return 0;
		} else {
			return lm.size();
		}
	}

	public String value(int index, String name) {
		Map<String, String> m = lm.get(index);
		return mValue(m, name);

	}

	private String mValue(Map<String, String> m, String name) {
		if (m.get(name) == null) {
			return null;
		} else {
			return m.get(name).toString();
		}

	}
	
	public ResultMap append(Map<String, String> m){
		lm.add(m);
		return this;
	}
	
	public ResultMap append(List<Map<String, String>> lm){
		for(Map<String, String> m :lm){
			lm.add(m);
		}
		return this;
	}
	
	public ResultMap append(ResultMap rm){
		for(Map<String, String> m :rm.getLM()){
			lm.add(m);
		}
		return this;
	}
	
	public ResultMap copy(){
		
		try {
			return (ResultMap) this.clone();
		} catch (CloneNotSupportedException e) {			
			e.printStackTrace();
		}
		return null;
	}
	


}
