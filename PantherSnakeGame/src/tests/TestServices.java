package tests;

import java.util.ArrayList;
import Model.Question;
import Model.QuestionLevel;

public class TestServices {

	public Question GenrateQuestionDetials(String q, int currectAnsw, QuestionLevel level, String team) {
		Question question = new Question();
		question.setQuestion(q);
		question.setLevel(level);
		question.setCurrectAnsw(currectAnsw);
		question.setTeam(team); 
		return question;
	}


	public ArrayList<String> generateQusAnswers(String s1,String s2,String s3,String s4){
		ArrayList<String> answers = new ArrayList<String>();
		answers.add(s1);
		answers.add(s2);
		answers.add(s3);
		answers.add(s4);

		return answers;
	}
	
	
}