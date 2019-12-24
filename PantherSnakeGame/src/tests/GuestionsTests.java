package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controller.sysData;
import Model.Question;
import Model.QuestionLevel;
import Model.RedQuestion;
import Model.WhiteQuestion;
import Model.YellowQuestion;
import recources.Constants;



public class GuestionsTests {
	TestServices m_services;
	String q = "Requirementss validation techniques are:";
	QuestionLevel level = QuestionLevel.Medium;
	int currectAnsw = 4;
	String team = "Panther"; 
	String ans1 = "Requirements reviews";
	String ans2 ="Prototyping";
	String ans3 ="Test-case generation";
	String ans4 ="All the answers are correct";
	

	private void TestAddQuestion() throws Exception{
		setUp();
		Question question = m_services.GenrateQuestionDetials(q, currectAnsw, level, team);
		ArrayList<String> answers = m_services.generateQusAnswers(ans1, ans2, ans3, ans4);
		question.setAnswers(answers);
		boolean flag = sysData.getInstance().addQuestion(question);
		
		assertEquals(true, flag);
	}
	
	
	private void TestReadJsonFile() throws Exception{
		setUp();
		
		boolean flag = sysData.getInstance().readQuestions();
		
		assertEquals(true, flag);
	}
	
	private void TestupdateQuestion() throws Exception{
		setUp();
		Question question = m_services.GenrateQuestionDetials(q, 3, level, team);
		ArrayList<String> answers = m_services.generateQusAnswers(ans1, ans2, ans4, ans3);
		question.setAnswers(answers);
		boolean flag = sysData.getInstance().updateQuestion(question);
		
		assertEquals(true, flag);
	}
	
	
	
	@Before
	public void setUp() throws Exception 
	{
		m_services = new TestServices();
	} 
	
	
	@Test
	public void testAddQues() throws Exception 
	{
		setUp();
		TestAddQuestion();
	}
	
	
	@Test
	public void testReadJsonFile() throws Exception 
	{
		setUp();
		TestReadJsonFile();
	}
	
	
	@Test
	public void testupdateQuestion() throws Exception 
	{
		setUp();
		TestupdateQuestion();
	}
	

	@Test
	public void checkQuestionNameFile() {
		assertEquals("PantherSnakeGame\\src\\recources\\questions.json", Constants.QUESTIONFILENAME );
	}
	
	
	@Test
	public void checkRedQuestionPoints() {
		RedQuestion redQuestion = new RedQuestion();
		assertEquals(3, redQuestion.getRightAnswerPoints());
		assertEquals(-30, redQuestion.getWrongAnswerPoints());
	}
	
	@Test
	public void checkWhiteQuestionPoints() {
		WhiteQuestion whiteQuestion = new WhiteQuestion();
		assertEquals(1, whiteQuestion.getRightAnswerPoints());
		assertEquals(-10, whiteQuestion.getWrongAnswerPoints());
	}
	
	@Test
	public void checkYellowQuestionPoints() {
		YellowQuestion yellowQuestion = new YellowQuestion();
		assertEquals(2, yellowQuestion.getRightAnswerPoints());
		assertEquals(-20, yellowQuestion.getWrongAnswerPoints());
	}

}