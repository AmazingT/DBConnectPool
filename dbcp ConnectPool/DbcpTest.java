package com.util.dbcp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 数据库连接测试
 * @author 周小波
 *
 */
public class DbcpTest {
	public static void main(String[] args) throws SQLException{
	
		Statement stmt = DBCPUtil.getConnection().createStatement();
		
		String sql = "select * from person";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			System.out.println(rs.getString("major"));
		}
		
		//释放资源
		DBCPUtil.release(rs, stmt, DBCPUtil.getConnection());
	}
}
