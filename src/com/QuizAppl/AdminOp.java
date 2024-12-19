package com.QuizAppl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class AdminOp {
	private static final String String = null;
	public static void getScoreById() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Student Id to get score");
		int Student_id = scanner.nextInt();
		DbConnection dbConnection = new DbConnection();
		Connection con = dbConnection.getConnection();
		String query = "select * from response where user_id =?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, Student_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println(" Student Name  "+ rs.getString("user_name"));
			System.out.println(" Student Score " + rs.getString("score"));
		}else {
			System.out.println("Wrong id");
		}
		
	}
	public static void printAllResponse() throws Exception {
		//TreeSet<Integer> map = new TreeSet<Integer>();
		//map.add()
		DbConnection dbConnection = new DbConnection();
		Connection con = dbConnection.getConnection();
		String query = "select * from response";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println(" Student Id " + rs.getString("user_id"));
			System.out.println(" Student Name  "+ rs.getString("user_name"));
			System.out.println(" Student Score " + rs.getString("score"));
		}
	}
	public static void adminDB() throws Exception {
		System.out.println("----- HELLO ADMIN -----");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n1. Display students score with detail");
			System.out.println("2. Fetch student data by ID");
			System.out.println("3. Add questions");
			System.out.println("4. Exit");
			int c = sc.nextInt();

			// 1.Display all Score
			if (c == 1) {

				DbConnection dbConnection = new DbConnection();
				Connection con = dbConnection.getConnection();
				String q = "Select * from quiz order by score DESC";
				PreparedStatement psmt = con.prepareStatement(q);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					System.out.println("First Name : " + rs.getString(2));
					System.out.println("Last Name : " + rs.getString(3));
					System.out.println("Score : " + rs.getInt(9));
					System.out.println("\n-------------------------------------------------\n");
				}
			}

			// Fetch score by ID
			if (c == 2) {

				System.out.println("Enter student's ID");
				int Id = sc.nextInt();
				DbConnection dbConnection = new DbConnection();
				Connection con = dbConnection.getConnection();
				String q = "Select * from quiz Where Id='" + Id + "'";
				PreparedStatement psmt = con.prepareStatement(q);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					System.out.println("Id : " + rs.getInt(1));
					System.out.println("First Name : " + rs.getString(2));
					System.out.println("Last Name : " + rs.getString(3));
					System.out.println("Username : " + rs.getString(4));
					System.out.println("Password : " + rs.getString(5));
					System.out.println("City : " + rs.getString(6));
					System.out.println("Email : " + rs.getString(7));
					System.out.println("MobileNumber : " + rs.getString(8));
					System.out.println("Score : " + rs.getInt(9));
					System.out.println("\n-------------------------------------------------\n");
				}
			}

			// Question & there option
			if (c == 3) {
				QueDb.AddQuestion();
			}

			if (c >= 4) {
				System.exit(0);
			}
		}
	}
}
