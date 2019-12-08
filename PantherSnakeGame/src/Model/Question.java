package Model;

import java.util.ArrayList;

public class Question {

	String question;
	ArrayList<String> answers;
	String currectAnsw;
	QuestionLevel level;
	
	/**
	 * contructor
	 * @param question 
	 * @param currectAnsw
	 * @param level
	 */
	public Question(String question, String currectAnsw, QuestionLevel level) {
		super();
		this.question = question;
		this.answers = new ArrayList<String>();
		this.currectAnsw = currectAnsw;
		this.level = level;
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
		this.answers = answers;
	}


	public String getCurrectAnsw() {
		return currectAnsw;
	}


	public void setCurrectAnsw(String currectAnsw) {
		this.currectAnsw = currectAnsw;
	}


	public QuestionLevel getLevel() {
		return level;
	}


	public void setLevel(QuestionLevel level) {
		this.level = level;
	}
	
	/* hashCode & equals */


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((currectAnsw == null) ? 0 : currectAnsw.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (currectAnsw == null) {
			if (other.currectAnsw != null)
				return false;
		} else if (!currectAnsw.equals(other.currectAnsw))
			return false;
		if (level != other.level)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	
	
}