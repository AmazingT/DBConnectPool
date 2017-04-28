package com.util.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 * dbcp数据库连接池
 * @author 周小波
 *
 */
public class DBCPUtil {
	private static DataSource ds;
	//读取资源文件
	static{
		try{
			InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties ps = new Properties();
			ps.load(in);//加载指定的配置文件中的数据到ps中
			ds = BasicDataSourceFactory.createDataSource(ps);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//外部调用的方法
	public static Connection getConnection(){
		Connection conn = null;
		try{
			conn = ds.getConnection();
			return conn;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//释放资源
	public static void release(ResultSet rs,Statement stmt,Connection conn){
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
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
