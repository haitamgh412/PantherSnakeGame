package View;


import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class HighScores {

	public JFrame scoreframe;
	private JTable table;


	/**
	 * Create the application.
	 */
	public HighScores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		scoreframe = new JFrame();
		scoreframe.getContentPane().setBackground(Color.WHITE);
		scoreframe.setIconImage(Toolkit.getDefaultToolkit().getImage(HighScores.class.getResource("/images/icon.png")));
		scoreframe.setTitle("high Scores");
		scoreframe.setBounds(100, 100, 674, 443);
		scoreframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreframe.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreen f = new MainScreen();
				f.framefirst.setVisible(true);
				scoreframe.dispose();	
			}
		});
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(HighScores.class.getResource("/images/back.jpg")));
		button.setBounds(15, 348, 62, 29);
		scoreframe.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HighScores.class.getResource("/images/score.jpg")));
		label.setBounds(0, -30, 326, 423);
		scoreframe.getContentPane().add(label);
		
		JLabel lblTop = new JLabel("Top 10");
		lblTop.setHorizontalAlignment(SwingConstants.CENTER);
		lblTop.setFont(new Font("Segoe Print", Font.PLAIN, 23));
		lblTop.setBounds(396, 16, 162, 56);
		scoreframe.getContentPane().add(lblTop);
		
		table = new JTable();
		table.setBounds(572, 297, -212, -208);
		scoreframe.getContentPane().add(table);
	}
}
