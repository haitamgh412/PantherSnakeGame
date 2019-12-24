package View;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Instructions {

	public JFrame Instructionsframe;

	/**
	 * Create the application.
	 */
	public Instructions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame Instructions = new JFrame();
		Instructions.setIconImage(Toolkit.getDefaultToolkit().getImage(Instructions.class.getResource("/images/instructionss.png")));
		Instructions.setTitle("Instructions");
		Instructionsframe = Instructions;
		Instructions.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreen f = new MainScreen();
				f.framefirst.setVisible(true);
				Instructionsframe.dispose();	
				
			}
		});
		btnBack.setIcon(new ImageIcon(Instructions.class.getResource("/images/back.jpg")));
		btnBack.setBounds(15, 460, 107, 45);
		Instructions.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Instructions.class.getResource("/images/unnamed.jpg")));
		lblNewLabel.setBounds(0, -7, 909, 528);
		Instructions.getContentPane().add(lblNewLabel);
		Instructionsframe.setBounds(100, 100, 931, 577);
	}
}
