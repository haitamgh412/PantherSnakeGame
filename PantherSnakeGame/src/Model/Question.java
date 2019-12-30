package Model;

import java.awt.Image;
import java.util.ArrayList;


public class Question {

	String question;
	ArrayList<String> answers;
	int currectAnsw;
	int question_x;
	int question_y;
	Image questionImage;
	String team;

	
	public Question(String question) {
		super();
		this.question = question;
		this.answers = new ArrayList<>();
	}
	
	/*
	 * empty constructor for the use of the sons classes
	 */
	public Question() {
		super();
		this.answers = new ArrayList<>();
	}
	
	/**
	 * Constructor
	 * @param question 
	 * @param currectAnsw
	 * @param level
	 */
	public Question(String question, int currectAnsw, String team) {
		super();
		this.question = question;
		this.answers = new ArrayList<String>();
		this.currectAnsw = currectAnsw;
		this.team=team;
	}


	/* getters & setters */

	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public ArrayList<String> getAnswers() {
		return answers;
	}


	public void setAnswers(ArrayList<String> answers) {
		if(answers.size()==4)
		this.answers = answers;
	}

	public void setAnswers(String ans) {
		if(this.answers !=null && this.answers.size()<4) {
			addAnswer(ans);
		}
	}
	public boolean addAnswer(String ans) {
		return answers.add(ans);
	}


	public int getCurrectAnsw() {
		return currectAnsw;
	}


	public void setCurrectAnsw(int currectAnsw) {
		this.currectAnsw = currectAnsw;
	}


	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public int getX() {
		return question_x;
	}
	
	public int getY() {
		return question_y;
	}
	
	public Image getImage() {
		return questionImage;
	}

	/*
	 * replace the coordinates of the Question
	 */
	public void random() {

		int a = (int) (Math.random() * Board.RAND_POS);
		this.question_x = ((a * Board.DOT_SIZE));

		a = (int) (Math.random() * Board.RAND_POS);
		this.question_y = ((a * Board.DOT_SIZE));
	}


	/* hashCode & equals */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [question=" + question + ", answers=" + answers + ", currectAnsw=" + currectAnsw + ", team="
				+ team + "]";
	}
	
	
}