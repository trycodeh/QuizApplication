package com.QuizAppl;

import java.util.Scanner;


public class start {
	public static void main(String[] args) throws Exception {
		// Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Quiz based application \n" + "User Operation \n" + 
				"1.Student Registration \n"
				+ "2.Student Login \n " 
				+ "3. Start Quiz  \n" 
				+ "" + "Admin Operation"
				+ "4. Display all students score as per ascending order \n" 
				+ "5. Fetch student score by using id \n"
				+ "6. Add question with 4 options into database \n");
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				// Student Register
				Registration registration = new Registration();
				registration.registerUser();
				break;
			case 2:
				// Student login
				StudentLogin studentLogin = new StudentLogin();
				studentLogin.login();
				break;
			case 3:
				Quiz quiz = new Quiz();
				quiz.startQuiz(2);
				break;
			case 4:
				AdminOp adminOp = new AdminOp();
				adminOp.printAllResponse();
				break;
			case 5: 
				AdminOp adminOp1= new AdminOp();
				adminOp1.getScoreById();
				break;
			case 6:
				QueDb queDb = new QueDb();
				queDb.AddQuestion();
				break;
			default:
				break;
			}
		}
	}
}
