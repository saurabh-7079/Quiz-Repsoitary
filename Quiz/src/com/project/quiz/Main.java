package com.project.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	 
	public static void main(String[] args) {
		
		Userdetail ud = new Userdetail();
	    String result =	ud.name();
	    String result1 = ud.email();
	    
		Scanner sc = new Scanner(System.in);
		String ans1;
		ArrayList<String> al = new ArrayList();
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
			PreparedStatement ps = con.prepareStatement("select * from question");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println("Enter your ans");
			    ans1= sc.next();
				al.add(ans1);
				System.out.println("------------------------");
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		try {
			for(int i=0; i<10; i++) {
				String value=al.get(i);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
				PreparedStatement ps1 = con.prepareStatement("update details set que1ans=?, que2ans=?, que3ans=?, que4ans=?, que5ans=?, que6ans=? where id=?");
				ps1.setString(i, value);
				ps1.execute();
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
