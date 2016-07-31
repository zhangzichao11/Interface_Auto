package com.util;
import java.sql.SQLException;


/**
 *@Time 
 *@Desriptions:
 *@Version: 1.0
 */
public interface IDBCon {
	
	 public int execute(String arg) throws SQLException;
	 public ResultMap select(String arg) throws SQLException;
}
