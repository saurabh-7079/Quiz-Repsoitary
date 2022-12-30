package com.project.quiz;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;	
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.sql.SQLException;
	
public class Main {
	static {
		System.out.println("Quiz test");
		System.out.println("------------------");
		}
		
	static int count=0;
	static int wrongcount=0;
    static int i=0;//user count.
    
	public static void main(String[] args) {

		for(int i=1;;i++) {
			count=0;
			System.out.println("User id: "+i);
		Userdetail ud = new Userdetail();
	    String result =	ud.name();
	    String result1 = ud.email();
	    System.out.println("Please wait questions are loading");
	    
		Scanner sc = new Scanner(System.in);
		String ans1;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
			PreparedStatement ps = con.prepareStatement("select * from quiz.question;");
		    ResultSet rs= ps.executeQuery();
		

		while(rs.next()) {
	    System.out.println("---------------------");
						
        Question question=new Question(rs.getString(2),rs);

		System.out.println("Enter your answer here:");
	    ans1= sc.next();
	    String name=rs.getString(7);
			    
		//map.put(ans1,name);
	    if(ans1.equalsIgnoreCase(name)) {
		System.out.println("your answer is Right");
		count++;
		}else {
	     	wrongcount++;
		    System.out.println("your answer is Wrong");
		}
			
	    Class.forName("com.mysql.cj.jdbc.Driver");
 		Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
 		PreparedStatement ps1 = con.prepareStatement("insert into quiz.user (name,email,userans)values(?,?,?)");
		ps1.setString(1,result);
		ps1.setString(2, result1);
	    ps1.setString(3,ans1 );	
	    ps1.execute();
//		System.out.println("------------------------");
				
		}
			System.out.println("--------------------");
			System.out.println("your score is:"+count +" out of 10");
			System.out.println("");
			System.out.println("you gave " + wrongcount +" Wronganswer.");
			System.out.println("");
			if(count>8) {
				System.out.println("Your grade is Class A");
			}else if(count>6 && count<8) {
				System.out.println("your grade is Class B");
			}else if(count==5) {
				System.out.println("your grade is Class C");
			}else {
				System.out.println("your are Failed");
			}
		
			System.out.println("========================================================");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con2= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
			PreparedStatement ps2 = con.prepareStatement("insert into quiz.result (name,score)values(?,?)");
			ps2.setString(1, result);
			ps2.setInt(2, count);
			ps2.execute();
//			System.out.println("-----------------------");
			System.out.println("You have successfully completed the quiz.");
//			System.out.println("");
			
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con3= DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","Root");
//			PreparedStatement ps3 = con3.prepareStatement("select * from quiz.result;");
//			//ResultSet rs1= ps3.executeQuery();
//			//System.out.println(rs1.getString("Score"));
//			
//			System.out.println("");
//			ps3.close();
			Result re=new Result();
			re.result();
			
			Scanner sca=new Scanner(System.in);
			System.out.println("If you want to continue then press 1 else press 2");
			int message = sca.nextInt();
//			int p =2;
			if(message==2) {
				break;
			} else if(message==1) {
				continue;
			}
			
			
		}
		
		catch(Exception e){
			System.out.println(e);
		}
	
		
		}
		
	
		

	 }
		
	}
