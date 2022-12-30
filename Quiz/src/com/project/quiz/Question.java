package com.project.quiz;

import java.sql.ResultSet;
import java.util.HashMap;

public class Question {
	String Que;
	ResultSet ans1;
	
	Question(String Que,ResultSet ans1){
		this.Que=Que;
		this.ans1=ans1;
		
		HashMap map=new HashMap();
		HashMap map1=new HashMap();
		for(int i=1;i<=1;i++) {
			map.put(i, Que);
			map1.put(i,this.ans1);
			System.out.println(map.get(i));
			//System.out.println(map1.get(i));
		}
		for(int j=3;j<=6;j++) {
			try {
		System.out.println(this.ans1.getString(j));	
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		
	}

}
