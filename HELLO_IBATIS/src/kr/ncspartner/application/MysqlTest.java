package kr.ncspartner.application;

import java.sql.*;

public class MysqlTest {

	public static void main(String[] args) {

		Connection conn;
		Statement stmt;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
		}

		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/womansw";

			String userId = "root";
			String userPass = "admin";

			conn = DriverManager.getConnection(jdbcUrl, userId, userPass);

			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select crud_id,crud_name,mobile from crudtable");
			
			while(rs.next()){
				String crud_id = rs.getString(1);
				String crud_name = rs.getString(2);
				String mobile = rs.getString(3);
				
				System.out.println("crud_id:"+crud_id);
				System.out.println("crud_name:"+crud_name);
				System.out.println("mobile:"+mobile);
				
			}

			System.out.println("제대로 연결되었습니다");

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
}