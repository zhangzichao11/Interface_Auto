package com.util;

public class DBConFactory {
	static final String DB_TYPE_MYSQL = "MYSQL";

	public static IDBCon getInstance(IDB db) {

		IDBCon dbcon = null;
		switch (db.getDbType()) {
		case DB_TYPE_MYSQL:
			dbcon = new MySqlcon(db);
			break;
		}
		return dbcon;
	}
}