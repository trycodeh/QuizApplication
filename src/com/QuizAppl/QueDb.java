package com.QuizAppl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class QueDb {
	static PreparedStatement ps = null;

	public static void insertQuestions(String qName, String option1, String option2, String option3, String option4,
			String optionc) throws SQLException {
		try {
			DbConnection dbConnection = new DbConnection();
			Connection con = dbConnection.getConnection();
			ps = con.prepareStatement(
					"insert into question(qus,option1,option2,option3,option4,answer)values(?,?,?,?,?,?)");
			ps.setString(1, qName);
			ps.setString(2, option1);
			ps.setString(3, option2);
			ps.setString(4, option3);
			ps.setString(5, option4);
			ps.setString(6, optionc);

			int i = ps.executeUpdate();
			System.out.println("Record inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddQuestion() throws SQLException {
		Scanner sc = new Scanner(System.in);
		QueDb que = new QueDb();

		System.out.println("Enter your Question>>");
		String qName = sc.nextLine();

		System.out.println("Enter your Options");
		System.out.println("Optn 1>>");
		String option1 = sc.nextLine();
		System.out.println("Optn 2>>");
		String option2 = sc.nextLine();
		System.out.println("Optn 3>>");
		String option3 = sc.nextLine();
		System.out.println("Optn 4>>");
		String option4 = sc.nextLine();
		System.out.println("Please enter Answer option !!");
		String optionc = sc.next();

		que.insertQuestions(qName, option1, option2, option3, option4, optionc);
	}
}