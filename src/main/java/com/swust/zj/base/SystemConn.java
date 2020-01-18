package com.swust.zj.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Service;
@Service
public class SystemConn {
	// 数据库地址
	 
	 ;
	private Connection connection=null;
	private PreparedStatement preparedStatement;

	public Connection getConnection(String url, String username, String driver, String password,String  dataName,String port) {
		 url = "jdbc:mysql://"+url+":"+port+"/"+dataName+"?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			System.out.println(url);
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			//preparedStatement = connection.prepareStatement(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void close() {
		try {
			this.connection.close();
			this.preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
