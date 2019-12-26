package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AddQuestions {

	public JFrame Addframe;


	/**
	 * Create the application.
	 */
	public AddQuestions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Addframe = new JFrame();
		Addframe.setBounds(100, 100, 450, 300);
		Addframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
