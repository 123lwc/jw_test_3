package com.lwc.upload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private Connection conn = null;
	private Statement sta = null;
	private ResultSet rs = null;
	public Connection getConn(){
		String url = "jdbc:mysql://localhost:3306/imginfo_db";
		String user = "root";
		String pwd = "123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.conn;
	}
	public int update(String sql) {
		int n = -1;
		try {
			conn = getConn();//��ȡ����
			this.sta = conn.createStatement();//��������ͨ��
			n = this.sta.executeUpdate(sql);//����ִ�б༭sql������һ������0��int
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public ResultSet query(String sql) {
		try {
			conn = getConn();
			this.sta = conn.createStatement();
			this.rs = this.sta.executeQuery(sql);//�÷���������sql����ѯ������һ������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int delete(String sql) {
		int n = -1;
		conn = getConn();
		try {
			this.sta = conn.createStatement();
			n = this.sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	public ResultSet select(String sql) {
		conn = getConn();
		try {
			this.sta = conn.createStatement();
			rs = this.sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
	}

}
