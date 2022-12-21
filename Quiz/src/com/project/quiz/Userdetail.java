package com.project.quiz;

import java.util.Scanner;

public class Userdetail {

	String name;
	String email;
	
	public String name() {
		System.out.println("Enter your name");
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		return name;
	}
	public String email() {
		System.out.println("Enter your email");
		Scanner sca = new Scanner(System.in);
		email = sca.next();
		return email;
	}
}
