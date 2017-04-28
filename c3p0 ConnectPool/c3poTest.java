package com.henu.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.connectdb.JDBCUtil;

public class c3poTest {
	private static Connection conn = null;
	static Statement stmt = null;
	
	public static void main(String[] args){
		conn = JDBCUtil.getConnection();
	
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String sql = "select * from user";
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("username"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBCUtil.close(conn, rs, stmt);
	}
}
