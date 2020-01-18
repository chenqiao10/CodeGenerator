package com.swust.zj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swust.zj.base.SystemConn;
import com.swust.zj.main.SSSGenerator;

@Controller
public class mainController {

	@Resource
	private SystemConn systemConn;
	
	
	@RequestMapping("/index")
	public String index() {

		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model,String driver, String url, String port, String dataName, String username, String password) throws SQLException {
List<String> tables=new ArrayList<>();
		Connection conn = systemConn.getConnection(url, username, driver, password, dataName, port);
		PreparedStatement preparedStatement;
		String sql="select table_name from information_schema.tables where table_schema='"+dataName+"'";
		if (conn != null) {
			preparedStatement = conn.prepareStatement(sql);
			ResultSet qs =preparedStatement.executeQuery();
			while(qs.next()) {
				tables.add(qs.getString(1));
			}
		} else {
           
		}
		model.addAttribute("tables", tables);
		return "tables";
	}
	@RequestMapping("/generator")
	public String generator(List<String> tables,String dataName,String projectName,String packageDir,String baseDir) throws Exception {
		SSSGenerator sg=new SSSGenerator( projectName, packageDir, baseDir);
		for(String table:tables) {
			sg.generator(table);
		}
		String sql="select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT from information_schema.columns where table_name='user' and TABLE_SCHEMA='"+dataName+"'";
		return sql;
	}
	
}
