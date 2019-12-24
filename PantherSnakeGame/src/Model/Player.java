package Model;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Player implements Comparable<Player>{
	
	
	private int userID  ;
	private String userName;
	// player Scores while playing current game
	private int playerScore;
	// all the scores of the player from all the games he players
	private TreeSet<Integer> scores;
	// the high score of the playe from all the games he players
	private int highScore;
	
	
	public Player(int userID, String userName) {
		super();
		this.userID = userID;
		this.userName = userName;
		// create sorted tree set to save all the scores
		scores =  new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
	}

	
	// getters && setters

	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getPlayerScore() {
		return playerScore;
	}


	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}


	public int getHighScore() {
		return highScore;
	}


	// get the first score (the highest) from sorted set
	public void setHighScore(int highScore) {
		this.highScore = scores.first();
	}


	public Set<Integer> getScores() {
		return scores;
	}


	public void setScores(TreeSet<Integer> scores) {
		this.scores = scores;
	}
	
	
	// method to add new score the tree set of the scores of the player
	 public void addScore(int score) {
			scores.add(score);
		}


	 // method to compare the highest score between the players
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return o.highScore>this.highScore ?-1:1;
	}


	// hashCode && equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + highScore;
		result = prime * result + playerScore;
		result = prime * result + ((scores == null) ? 0 : scores.hashCode());
		result = prime * result + userID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Player other = (Player) obj;
		if (highScore != other.highScore)
			return false;
		if (playerScore != other.playerScore)
			return false;
		if (scores == null) {
			if (other.scores != null)
				return false;
		} else if (!scores.equals(other.scores))
			return false;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Player [userID=" + userID + ", userName=" + userName + ", scores=" + scores + ", highScore=" + highScore
				+ "]";
	}
}