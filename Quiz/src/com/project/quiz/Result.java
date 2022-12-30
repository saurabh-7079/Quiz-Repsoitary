package com.project.quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Driver;

public class Result {
	public void result() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
			PreparedStatement ps = con.prepareStatement("select * from quiz.result;");
			
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
//			PreparedStatement ps1 = con1.prepareStatement("select * from quiz.user;");
//			
		ResultSet rs= ps.executeQuery();
//		ResultSet rs1=ps1.executeQuery();
		
		System.out.println("List of all student.");
		while(rs.next()) {
			System.out.print("userid:"+ rs.getInt("id") +", ");
			System.out.print("User name="+rs.getString("name")+", ");
			System.out.println("Score= "+rs.getString("score")+"   ");
			//System.out.println("email"+ rs1.getString("email"));
		
		}
			System.out.println("==================End of Quiz====================");
		con.close();
		ps.close();
		rs.close();
		
				
			
		
			
			}catch(Exception e) {
				System.out.println(e);
			}
			
	}

}