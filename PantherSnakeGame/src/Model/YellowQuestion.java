package Model;


import View.FoodView;

public class YellowQuestion extends Question{

	private final int rightAnswerPoints=2;
	private final int wrongAnswerPoints=-20;
	
	public YellowQuestion(String question, int currectAnsw,String team) {
		super(question, currectAnsw, team);
		generateQuestion();
		// TODO Auto-generated constructor stub
	}
	
	public YellowQuestion() {
		generateQuestion();
	}
	
	@SuppressWarnings("static-access")
	public void generateQuestion() {
        
        int a = (int) (Math.random() * Board.RAND_POS);
        this.question_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.question_y = ((a * Board.DOT_SIZE));
        
		FoodView foodView=new FoodView();
        this.questionImage=foodView.getYellowQuestion();
        
	}

	public int getRightAnswerPoints() {
		return rightAnswerPoints;
	}

	public int getWrongAnswerPoints() {
		return wrongAnswerPoints;
	}

	/*
	 * the method check the Answer 
	 * if the Answer is right returns getRightAnswerPoints()
	 * if the Answer is wrong returns GetWrongAnswerPoints()
	 */
	public int getAnswerPoints(boolean answer) {
		if (answer)return rightAnswerPoints;
		else return wrongAnswerPoints;
	}
}