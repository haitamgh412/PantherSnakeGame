package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Model.Board;

public class SnakeView {

	public JFrame Snakeframe;

	/**
	 * Create the application.
	 */
	public SnakeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Snakeframe = new JFrame();
		Snakeframe.setBounds(100, 100, 925, 658);
		Snakeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Snakeframe.getContentPane().setLayout(null);
		 Board board = new Board();
		 board.setBounds(0, 0, 600, 600);
		   Snakeframe.getContentPane().add(board);
		   board.setLayout(null);
	}

}
