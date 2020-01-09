package View;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Instructions1 {

	public JFrame Iframe;


	/**
	 * Create the application.
	 */
	public Instructions1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Iframe = new JFrame();
		Iframe.setResizable(false);
		Iframe.setTitle("instructons");
		Iframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Instructions1.class.getResource("/images/instructionss.png")));
		Iframe.setBounds(100, 100, 952, 567);
		Iframe.getContentPane().setLayout(null);
		
		
		JButton btnBackToGame = new JButton("back to game ");
		btnBackToGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Iframe.dispose();
			}
		});
		btnBackToGame.setBackground(Color.WHITE);
		btnBackToGame.setBounds(257, 442, 175, 41);
		Iframe.getContentPane().add(btnBackToGame);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Instructions1.class.getResource("/images/unnamed1.png")));
		label.setBounds(0, 0, 930, 522);
		Iframe.getContentPane().add(label);
	}
}
