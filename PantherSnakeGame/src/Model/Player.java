package Model;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Player implements Comparable<Player>{


	private String userName;
	// all the scores of the player from all the games he players
	private TreeSet<Integer> scores;
	// the high score of the player from all the games he players
	private int highScore;


	public Player() {
		scores =  new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
	}


	public Player(String userName) {
		super();
		this.userName = userName;
		// create sorted tree set to save all the scores
		scores =  new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
	}


	// getters && setters



	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getHighScore() {
		updateHighScore();
		return highScore;
	}


	// get the first score (the highest) from sorted set
	public void updateHighScore() {
		if(!scores.isEmpty())
			this.highScore = scores.last();
	}


	public void setHighScore(int highScore) {
		this.highScore = highScore;
		updateHighScore();
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
		updateHighScore();
	}


	// method to compare the highest score between the players
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return o.highScore>this.highScore ?1:-1;
	}


	// hashCode && equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		return "Player [userName=" + userName + ", scores=" + scores + ", highScore=" + highScore + "]";
	}





}