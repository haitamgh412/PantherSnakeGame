package Model;

import javax.swing.ImageIcon;

public class RedQuestion extends Question {
	

	private final int rightAnswerPoints=3;
	private final int wrongAnswerPoints=-30;
	
	public RedQuestion(String question, String currectAnsw, QuestionLevel level) {
		super(question, currectAnsw, level);
		generateQuestion();
		// TODO Auto-generated constructor stub
	}
	
	public RedQuestion() {
		generateQuestion();
	}
	
	public void generateQuestion() {
		
		
		ImageIcon iia = new ImageIcon(Apple.class.getResource("/images/redQ.png"));
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
	 * replace the coordinates of the Question
	 */
//	public void random() {
//		
//        int a = (int) (Math.random() * Board.RAND_POS);
//        this.question_x = ((a * Board.DOT_SIZE));
//
//        a = (int) (Math.random() * Board.RAND_POS);
//        this.question_y = ((a * Board.DOT_SIZE));
//	}
	
	
}
