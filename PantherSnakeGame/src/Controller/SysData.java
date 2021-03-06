package Controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.Player;
import Model.Question;
import Model.RedQuestion;
import Model.WhiteQuestion;
import Model.YellowQuestion;
import recources.*;


public class SysData {
	private static SysData sysdata;
	/**
	 * saving questions details 
	 */
	private static ArrayList<Question> questions ;
	private static TreeSet<Player> players;
	private static ArrayList<RedQuestion> redQuestions ;
	private static ArrayList<WhiteQuestion> WhiteQuestions ;
	private static ArrayList<YellowQuestion> yellowQuestions ;




	private SysData(){
		questions=new ArrayList<Question>();
		players = new TreeSet<Player>();
		redQuestions = new ArrayList<RedQuestion>();
		WhiteQuestions = new ArrayList<WhiteQuestion>();
		yellowQuestions = new ArrayList<YellowQuestion>();

	}

	public static SysData getInstance() {
		if(sysdata==null) { 
			sysdata=new SysData();			
		}
		return sysdata; 
	}

	public ArrayList<Player> getTopPlayers() {
		ArrayList<Player> temp = new ArrayList<>(players);
		Collections.sort(temp);
		int counter=0;
		ArrayList<Player> top = new ArrayList<Player>();
		for(Player p : temp) {
			if(counter<=10) {
				top.add(p);
				counter++;
			}
		}
		return top;
	}


	public ArrayList<Question> getQuestionsssss() {
		//		questions.clear();
		//		readQuestions();	
		if(questions==null)
			questions=new ArrayList<Question>();
		return questions;
	}
	
	public Question getSpecificQuestion(String question) {
		for(Question q : questions) {
			if(q.getQuestion().equals(question))
				return q;
		}
		return null;
	}
	
	public ArrayList<RedQuestion> getRedQues() {
		if(redQuestions==null)
			redQuestions = new ArrayList<RedQuestion>();
		return redQuestions;
	}
	
	public ArrayList<WhiteQuestion> getWhiteQues() {
		if(WhiteQuestions==null)
			WhiteQuestions = new ArrayList<WhiteQuestion>();
		return WhiteQuestions;
	}
	
	public ArrayList<YellowQuestion> getYelloweQues() {
		if(yellowQuestions==null)
			yellowQuestions = new ArrayList<YellowQuestion>();
		return yellowQuestions;
	}



	public TreeSet<Player> getPlayers() {
		if(players==null)
			return new TreeSet<Player>();
		return players;
	}

	public Player getPlayer(String name) {
		for (Player p : players) {
			if(p.getUserName().equals(name))
				return p;
		}
		return null;
	}

	public boolean checkIfPlayerExist(Player player) {
		if (player==null) 
			return false;

		for (Player p : players) {
			if(player.getUserName().equals(p.getUserName()))
				return true;
		}

		return false;
	}

	public boolean checkIfQuestionExist(Question question) {
		if (question==null) 
			return false;

		if(questions.contains(question))
			return true;

		return false;
	}

	/**
	 * adding a player to the array of the players
	 * @return true if the array not contains this player and added it else return false
	 */
	public boolean addPlayer(Player player){
		if(player == null)
			return false;

		for (Player p : players) {
			if(player.getUserName().equals(p.getUserName()))
				return false;
		}

		return players.add(player);

	}

	/**
	 * 	writing a player to the json file 
	 * @param question
	 */	
	@SuppressWarnings("unchecked")
	public void writePlayers(Player p) {
		JSONArray jsarray=new JSONArray();
		JSONObject jobject=new JSONObject();
		addPlayer(p);
		for(Player player: getPlayers())   {
			JSONObject obj=new JSONObject();
			obj.put("userName",player.getUserName()); 
			JSONArray scores = new JSONArray();
			for(Integer s:player.getScores()) {
				scores.add(s);	        			
			}
			obj.put("Scores", scores);
			obj.put("HighScore", player.getHighScore());


			jsarray.add(obj);
		}
		try {
			removeAndCreateNewFile(Constants.PLAYERSILENAME);
		}catch(Exception ex) {

		}
		try (FileWriter f = new FileWriter(Constants.PLAYERSILENAME)) {
			jobject.put("players", jsarray);
			f.write(jobject.toJSONString());
		} 
		catch(Exception ex) {
		}
	}


	/**
	 * 
	 * @return list of players
	 */
	public TreeSet<Player> getPlayersAfterRead() {
		readPlayers();		
		return players;
	}

	/**
	 * reading the players from json file 
	 */
	public boolean readPlayers(){  
		try{
			JSONParser jparser = new JSONParser();
			Object object;
			object = jparser.parse(new FileReader(new File(Constants.PLAYERSILENAME)));
			JSONObject jo=(JSONObject) object;
			JSONArray jArr=(JSONArray) jo.get("players");
			for(Object o:jArr) {
				Player player = new Player();
				JSONObject jobject=(JSONObject) o;

				player.setUserName(String.valueOf(jobject.get("userName")));

				JSONArray scores=(JSONArray) jobject.get("Scores");
				if(scores!=null) {
					for(Object a: scores) {
						player.addScore(Integer.parseInt((String.valueOf(a)))); 
						player.setHighScore(Integer.parseInt(String.valueOf(jobject.get("HighScore"))));	
					}

					addPlayer(player);
				}

			}

			return true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
	}


	/**
	 * update a Player
	 * @param q
	 * @return true if the Player updated successfully else return false
	 */
	public boolean updatePlayer(Player player) {
		if(player==null)
			return false;
		boolean flag = false;

		for (Player p : players) {
			if(player.getUserName().equals(p.getUserName()))
				flag = true;
		}
		if(flag == false) {
			return false;
		}
		players.remove(player);
		addPlayer(player);
		writePlayers(player);
		return true;
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

				int level = Integer.parseInt(String.valueOf( jobject.get("level")));
				if (level == 1) {
					question = new WhiteQuestion();
					question.setQuestion(jobject.get("question").toString());
				}
				else if (level == 2) {
					question = new YellowQuestion();
					question.setQuestion(jobject.get("question").toString());
				}
				else {
					question = new RedQuestion();
					question.setQuestion(jobject.get("question").toString());
				}
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

		if(questions.contains(question)) {
			return false;
		}
		//		for (Question q : questions) {
		//			if(q.getQuestion().equals(q.getQuestion())) {
		//				System.out.println("yeeees");
		//				return false;
		//			}
		//		}

		if(question.getClass().getSimpleName().equals("RedQuestion"))
			redQuestions.add((RedQuestion) question);
		else if(question.getClass().getSimpleName().equals("WhiteQuestion"))
			WhiteQuestions.add((WhiteQuestion) question);
		else
			yellowQuestions.add((YellowQuestion) question);

		return questions.add(question);
	}


	/**
	 * 	writing a question to the json file 
	 * @param question
	 */	
	@SuppressWarnings("unchecked")
	public void writeQuestions(Question q) {
		addQuestion(q);
		JSONArray jsarray=new JSONArray();
		JSONObject jobject=new JSONObject();
		for(Question question: getQuestionsssss())   {
			JSONObject obj=new JSONObject();
			obj.put("question",question.getQuestion()); 
			JSONArray answers = new JSONArray();
			for(String ans:question.getAnswers()) {
				answers.add(ans);	        			
			}
			obj.put("answers", answers);
			obj.put("correct_ans", question.getCurrectAnsw());
			if(question.getClass().getSimpleName().equals("WhiteQuestion"))
				obj.put("level", 1);
			else if(question.getClass().getSimpleName().equals("YellowQuestion"))
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
	 * 	rewriting a question to the json file 
	 * @param question
	 */	
	@SuppressWarnings("unchecked")
	public void reWriteQuestions() {
		JSONArray jsarray=new JSONArray();
		JSONObject jobject=new JSONObject();
		for(Question question: getQuestionsssss())   {
			JSONObject obj=new JSONObject();
			obj.put("question",question.getQuestion()); 
			JSONArray answers = new JSONArray();
			for(String ans:question.getAnswers()) {
				answers.add(ans);	        			
			}
			obj.put("answers", answers);
			obj.put("correct_ans", question.getCurrectAnsw());
			if(question.getClass().getSimpleName().equals("WhiteQuestion"))
				obj.put("level", 1);
			else if(question.getClass().getSimpleName().equals("YellowQuestion"))
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
		if(!questionFileName.equals(Constants.QUESTIONFILENAME) && !questionFileName.equals(Constants.PLAYERSILENAME)) {
			return false;
		}
		if(questionFileName.equals(Constants.QUESTIONFILENAME)) {
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
		}
		else {
			File f=null;
			f=new File(Constants.PLAYERSILENAME);
			if(f.isFile())
				f.delete();
			try {
				f.createNewFile();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	/**
	 * update a question
	 * @param q
	 * @return true if the question updated successfully else return false
	 */
	public boolean RemoveQuestion(Question question) {
		if(question==null)
			return false;

		Question temp = new Question();
		boolean flag=false;
		for(Question q : questions) {
			if(q!=null)
				if(question.getQuestion().equals(q.getQuestion())) {
					temp = q;
					flag = true;
				}
		}
		if(flag==false) {
			return false;
		}


		questions.remove(temp);
		if(question.getClass().getSimpleName().equals("RedQuestion"))
			redQuestions.remove((RedQuestion) question);
		else if(question.getClass().getSimpleName().equals("WhiteQuestion"))
			WhiteQuestions.remove((WhiteQuestion) question);
		else
			yellowQuestions.remove((YellowQuestion) question);
		
		reWriteQuestions();
		return true;
	}


	/**
	 * update a question
	 * @param q
	 * @return true if the question updated successfully else return false
	 */
	public boolean updateQuestion(Question question) {
		if(question==null)
			return false;

		Question temp = new Question();
		boolean flag=false;
		for(Question q : questions) {
			if(q!=null)
				if(question.getQuestion().equals(q.getQuestion())) {
					temp = q;
					flag = true;
				}
		}
		if(flag==false) {
			return false;
		}

		questions.remove(temp);
		if(question.getClass().getSimpleName().equals("RedQuestion"))
			redQuestions.remove((RedQuestion) question);
		else if(question.getClass().getSimpleName().equals("WhiteQuestion"))
			WhiteQuestions.remove((WhiteQuestion) question);
		else
			yellowQuestions.remove((YellowQuestion) question);
		
		addQuestion(question);
		writeQuestions(question);
		return true;
	}

}