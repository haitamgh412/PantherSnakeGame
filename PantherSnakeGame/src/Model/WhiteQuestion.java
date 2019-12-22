package Model;

import javax.swing.ImageIcon;

public class WhiteQuestion extends Question {
	
	private final int rightAnswerPoints=1;
	private final int wrongAnswerPoints=-10;

	public WhiteQuestion(String question, String currectAnsw, QuestionLevel level) {
		super(question, currectAnsw, level);
		generateQuestion();
		// TODO Auto-generated constructor stub
	}
	
	public WhiteQuestion() {
		generateQuestion();
	}
	
	public void generateQuestion() {
		
		
		ImageIcon iia = new ImageIcon(Apple.class.getResource("/images/whiteQ.png"));
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
	
//	/*
//	 * replace the coordinates of the Question
//	 */
//	public void random() {
//		
//        int a = (int) (Math.random() * Board.RAND_POS);
//        this.question_x = ((a * Board.DOT_SIZE));
//
//        a = (int) (Math.random() * Board.RAND_POS);
//        this.question_y = ((a * Board.DOT_SIZE));
//	}
	
	
}
