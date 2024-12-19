package com.QuizAppl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	private List<Question> questions;
	private int currentQuestionIndex;

	// Getters and setters

	public void startQuiz(int id) throws Exception {
		Question question = new Question();
		List<Question> allQuestions = question.fetchQuestion();
		int result = 0;
		Scanner scanner = new Scanner(System.in);
		int i = 1;
		for (Question q : allQuestions) {
			System.out.println((i++) + ")" + q.getQuestionText());
			System.out.println("A )" + q.getOption1());
			System.out.println("B )" + q.getOption2());
			System.out.println("C )" + q.getOption3());
			System.out.println("D )" + q.getOption4());
			System.out.println();
			System.out.println("Enter your choice ..");
			String ans = scanner.next();

			if (q.getCorrectAnswer().equalsIgnoreCase(ans)) {
				result++;
			}
		}
		int per = (100 * result) / 10;
		System.out.println("Percentage : " + per + " \nYour Score was : " + result);
		if (per >= 90) {
			System.out.println("Grade : A+");
		} else if (per > 70 && per <= 80) {
			System.out.println("Grade : A");
		} else if (per > 60 && per <= 70) {
			System.out.println("Grade : B");
		} else if (per > 50 && per <= 60) {
			System.out.println("Grade : C");
		} else if (per >= 40 && per <= 50) {
			System.out.println("Grade : D");
		} else {
			System.out.println("You are fail...");
		}
		System.out.print(id);
		storeScore(id, result);
	}

	public static void storeScore(int Student_id, int result) throws Exception {
		DbConnection dbConnection = new DbConnection();
		Connection con = dbConnection.getConnection();
		String name = getfirstName(Student_id);
		String query = " insert into response (user_id ,user_name,score) values(?,?,?)";
		PreparedStatement ps =con.prepareStatement(query);
		ps.setInt(1, Student_id);
		ps.setString(2, name);
		ps.setInt(3, result);
		ps.execute();
	}

	public void nextQuestion() {
		// Implement next question logic
	}

	public static String getfirstName(int student_id) throws Exception {
		DbConnection dbConnection = new DbConnection();
		Connection con = dbConnection.getConnection();
		String query = "select * from logindetail where user_id =?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, student_id);
		ResultSet rs = ps.executeQuery();
		String name = "";
		if(rs.next()) {
			name = rs.getString("USER_NAME");
		}
		return name;
	}

	public void submitQuiz() {
		// Implement quiz submission logic, including score calculation and result
		// storage
	}

	public void calculateScore() {
		// Implement score calculation logic
	}

	Question q = new Question();

}
