package Model;

import javax.swing.ImageIcon;

public class YellowQuestion extends Question{

	private final int rightAnswerPoints=2;
	private final int wrongAnswerPoints=-20;
	
	public YellowQuestion(String question, int currectAnsw, QuestionLevel level,String team) {
		super(question, currectAnsw, level, team);
		generateQuestion();
		// TODO Auto-generated constructor stub
	}
	
	public YellowQuestion() {
		generateQuestion();
	}
	
	public void generateQuestion() {
		
		
		ImageIcon iia = new ImageIcon(Apple.class.getResource("/images/yellowQ.png"));
        this.questionImage = iia.getImage();
        
        int a = (int) (Math.random() * Board.RAND_POS);
        this.question_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.question_y = ((a * Board.DOT_SIZE));
        
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
	public int getAnswerPoints() {
		//TODO
		return 0;
	}
}