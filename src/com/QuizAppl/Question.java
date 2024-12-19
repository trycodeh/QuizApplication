package com.QuizAppl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Question {
	    @Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", correctAnswer=" + correctAnswer + "]";
	}

		private int id;
	    private String questionText;
	    private String option1;
	    private String option2;
	    private String option3;
	    private String option4;
	    private String correctAnswer;

	    // Getters and setters

	    public static List<Question> fetchQuestion() throws Exception {
	        DbConnection dbConnection = new DbConnection();
	        Connection con= dbConnection.getConnection();
	        
	        String query = "select * from question";
	        PreparedStatement ps=con.prepareStatement(query);
	        ResultSet resultSet = ps.executeQuery();
	        List<Question> allQuestion =new ArrayList<Question>();
	        while(resultSet.next()) {
	        	Question question = new Question(resultSet.getInt("qus_Id"), resultSet.getString("qus"), resultSet.getString("option1"), resultSet.getString("option2"), 
	        							resultSet.getString("option3"), resultSet.getString("option4"),resultSet.getString("answer"));
	        	allQuestion.add(question);
	        }
	        return allQuestion;
	    }
	    public static void printQuesion() throws Exception {
	    	List<Question> allQuestions = fetchQuestion();
	    	for(Question q: allQuestions) {
	    		System.out.println(q.getQuestionText() );
	    		System.out.println("A )" + q.getOption1());
	    		System.out.println("B )" +q.getOption2());
	    		System.out.println("C )"+ q.getOption3());
	    		System.out.println("D )" + q.getOption4());
	    		System.out.println();
	    	}
	    }
	    public Question() {
			super();
		}

		public Question(int id, String questionText, String option1, String option2, String option3, String option4,
				String correctAnswer) {
			super();
			this.id = id;
			this.questionText = questionText;
			this.option1 = option1;
			this.option2 = option2;
			this.option3 = option3;
			this.option4 = option4;
			this.correctAnswer = correctAnswer;
		}

		public void checkAnswer(int userAnswer) {
	        // Implement answer checking logic
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getQuestionText() {
			return questionText;
		}

		public void setQuestionText(String questionText) {
			this.questionText = questionText;
		}

		public String getOption1() {
			return option1;
		}

		public void setOption1(String option1) {
			this.option1 = option1;
		}

		public String getOption2() {
			return option2;
		}

		public void setOption2(String option2) {
			this.option2 = option2;
		}

		public String getOption3() {
			return option3;
		}

		public void setOption3(String option3) {
			this.option3 = option3;
		}

		public String getOption4() {
			return option4;
		}

		public void setOption4(String option4) {
			this.option4 = option4;
		}

		public String getCorrectAnswer() {
			return correctAnswer;
		}

		public void setCorrectAnswer(String correctAnswer) {
			this.correctAnswer = correctAnswer;
		}
}
