package com.util;

import org.apache.log4j.Logger;

public class MySqlImpl extends DBImpl {
	Logger log = Logger.getLogger(this.getClass());
	public String getUrl() {
		String url = "jdbc:mysql://" + this.getDBHost() + ":" + this.getDBPort() + "/" + this.getDBName();
		return url;
	}

}