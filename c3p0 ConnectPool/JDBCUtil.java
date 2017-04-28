package com.util.connectdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	/**
	 * c3p0连接方式一：xml文件/properties文件配置
	 * @author 周小波
	 *
	 */
	private static Connection conn;
	private static DataSource ds = new ComboPooledDataSource("mysql");
	
	public static Connection getConnection(){
        try {
            conn = ds.getConnection();
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接出错",e);
        }
    }	

	public static void close(Connection conn,ResultSet rs,Statement stmt){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			conn = null;
		}
		
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			rs = null;
		}
		
		if(stmt!=null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			stmt = null;
		}
	}
	/**
	 * c3p0连接方式二：代码方式
	 */
	/*
	private static Connection conn;
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    
    public static Connection getConnection() {
		try {
	        ds.setDriverClass("com.mysql.jdbc.Driver");
	        ds.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&useSSL=false");
	        ds.setUser("root");
	        ds.setPassword("1314");
	        conn = ds.getConnection();
	    } catch (SQLException r) {
	        r.printStackTrace();
	    } catch (PropertyVetoException e) {
	        e.printStackTrace();
	    }
    	return conn;
    }
   */
}
