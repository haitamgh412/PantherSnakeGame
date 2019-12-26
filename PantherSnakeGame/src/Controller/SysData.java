package Controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import Model.Question;
import Model.QuestionLevel;
import recources.*;


public class sysData {
	private static sysData sysdata;
	/**
	 * saving questions details 
	 */
	private static ArrayList<Question> questions ;

	private sysData(){
		questions=new ArrayList<Question>();
	}

	public static sysData getInstance() {
		if(sysdata==null) { 
			sysdata=new sysData();			
		}
		return sysdata; 
	}


	public ArrayList<Question> getQuestionsssss() {
		//		questions.clear();
		//		readQuestions();	
		if(questions==null)
			questions=new ArrayList<Question>();
		return questions;
	}

	/**
	 * 
	 * @return list of questions
	 */
	public ArrayList<Question> getQuestionsAfterRead() {
		readQuestions();		
		return questions;
	}

	/**
	 * reading the questions from json file 
	 */
	public boolean readQuestions(){  
		try{
			JSONParser jparser = new JSONParser();
			Object object;
			object = jparser.parse(new FileReader(new File(Constants.QUESTIONFILENAME)));
			JSONObject jo=(JSONObject) object;
			JSONArray jArr=(JSONArray) jo.get("questions");
			for(Object o:jArr) {
				Question question=new Question();
				JSONObject jobject=(JSONObject) o;
				question.setQuestion(jobject.get("question").toString());
				int level = Integer.parseInt(String.valueOf( jobject.get("level")));
				if (level == 1)
					question.setLevel(QuestionLevel.Easy);
				else if (level == 2)
					question.setLevel(QuestionLevel.Medium);
				else
					question.setLevel(QuestionLevel.Hard);
				question.setCurrectAnsw(Integer.parseInt(String.valueOf(jobject.get("correct_ans"))));
				question.setTeam(jobject.get("team").toString());        		 
				JSONArray answers=(JSONArray) jobject.get("answers");
				for(Object a: answers) {
					question.setAnswers((String) a); 
				}
				//	System.out.println(question);
				addQuestion(question); 
			}
			//			System.out.println("questionsss");
			//			System.out.println(questions.size());


			return true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
	}





	/**
	 * adding a question to the array of the questions
	 * @return true if the array not contains this question and added it else return false
	 */
	public boolean addQuestion(Question question){
		if(question == null)
			return false;
		if(questions.contains(question))
			return false;

		return questions.add(question);

	}

	/**
	 * 	writing a question to the json file 
	 * @param question
	 */	
	@SuppressWarnings("unchecked")
	public void writeQuestions() {

		JSONArray jsarray=new JSONArray();
		JSONObject jobject=new JSONObject();

		for(Question question: getQuestionsAfterRead())   {
			JSONObject obj=new JSONObject();
			obj.put("question",question.getQuestion()); 
			JSONArray answers = new JSONArray();
			for(String ans:question.getAnswers()) {
				answers.add(ans);	        			
			}
			obj.put("answers", answers);
			obj.put("correct_ans", question.getCurrectAnsw());
			if(question.getLevel().equals(QuestionLevel.Easy))
				obj.put("level", 1);
			else if(question.getLevel().equals(QuestionLevel.Medium))
				obj.put("level", 2);
			else
				obj.put("level", 3);
			obj.put("team", question.getTeam());
			jsarray.add(obj);
		}
		try {
			removeAndCreateNewFile(Constants.QUESTIONFILENAME);
		}catch(Exception ex) {

		}
		try (FileWriter f = new FileWriter(Constants.QUESTIONFILENAME)) {
			jobject.put("questions", jsarray);
			f.write(jobject.toJSONString());
		} 
		catch(Exception ex) {
		}
	}

	/**
	 * removing file and creating a new version of it
	 * @param fileName : the file name
	 * @return true if removed and created new successfully else return false
	 */
	public boolean removeAndCreateNewFile(String questionFileName) {
		if(!questionFileName.equals(Constants.QUESTIONFILENAME)) {
			return false;
		}
		File f=null;
		f=new File(Constants.QUESTIONFILENAME);
		if(f.isFile())
			f.delete();
		try {
			f.createNewFile();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * update a question
	 * @param q
	 * @return true if the question updated successfully else return false
	 */
	public boolean updateQuestion(Question question) {
		if(question==null)
			return false;
		if(!questions.contains(question)) {
			return false;
		}
		questions.remove(question);
		addQuestion(question);
		writeQuestions();
		return true;
	}
	

}