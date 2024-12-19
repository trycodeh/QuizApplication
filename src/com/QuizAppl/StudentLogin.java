package com.QuizAppl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class StudentLogin {
	public static void login() {
			Scanner sc=new Scanner(System.in);{
			try {
				DbConnection dbConnection = new DbConnection();
				Connection con = dbConnection.getConnection();
				
				System.out.println("Enter User name : ");
				String Username = sc.next();
				System.out.println("Enter Password : ");
				String password = sc.next();
				String query="Select * from logindetail Where USER_NAME =? AND PASSWORD=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, Username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Logging in.....");
						System.out.println("Welcome to the Quiz Application !");
						
						int id= rs.getInt("user_id");
						System.out.println("1. Start Quiz  \n" );
						int choice = sc.nextInt();
						switch (choice) {
						case 1:
							Quiz quiz = new Quiz();
							quiz.startQuiz( id);
							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + choice);
						}
						
						
						
						
					/*try {
						PreparedStatement psmt = con.prepareStatement("Update quiz set Score='"+score+"' Where Username='"+Username+"' && Pass='"+password+"'");
						psmt.execute();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("\nExit From Quiz : [YES/NO])");
					String a = sc.next();
					if (a.equalsIgnoreCase("yes")) {
						System.exit(0);
					}else{
						//Start.start();
					}*/
				}else {
					System.out.println("Please Enter Valid Username & Passsword");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}
