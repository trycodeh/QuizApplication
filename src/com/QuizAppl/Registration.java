package com.QuizAppl;

import java.sql.*;
import java.util.Scanner;

public class Registration {

	public static void registerUser() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first name: ");
		String firstName = scanner.nextLine();
		System.out.print("Enter last name: ");
		String lastName = scanner.nextLine();
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		System.out.print("Enter city: ");
		String city = scanner.nextLine();
		System.out.print("Enter email: ");
		String email = scanner.nextLine();
		System.out.print("Enter mobile number: ");
		int mobileNumber = scanner.nextInt();

		try {
			DbConnection dbConnection = new DbConnection();
			Connection con = dbConnection.getConnection();

			String sql = "INSERT INTO logindetail (USER_NAME, USER_FIRST_NAME, USER_LAST_NAME, USER_CITY, USER_EMAIL, USER_MOBILE, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, city);
			stmt.setString(5, email);
			stmt.setInt(6, mobileNumber);
			stmt.setString(7, password);
			stmt.executeUpdate();
			System.out.println("User registered successfully!");

		} catch (SQLException e) {
			System.out.println("Error registering user: " + e.getMessage());
		}
	}
}
