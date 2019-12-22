package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Model.Board;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

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
		Snakeframe.setForeground(new Color(204, 255, 204));
		Snakeframe.setBackground(new Color(255, 255, 255));
		Snakeframe.setIconImage(Toolkit.getDefaultToolkit().getImage(SnakeView.class.getResource("/images/icon.png")));
		Snakeframe.getContentPane().setBackground(new Color(255, 255, 255));
		Snakeframe.setTitle("SnakeGame_panther");
		Snakeframe.setBounds(100, 100, 925, 658);
		Snakeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Snakeframe.getContentPane().setLayout(null);
		 Board board = new Board();
		 board.setBackground(new Color(204, 255, 204));
		 board.setBounds(0, 0, 600, 600);
		   Snakeframe.getContentPane().add(board);
		   board.setLayout(null);
		   
		   JLabel lblSnakeGame = new JLabel("Snake Game ");
		   lblSnakeGame.setHorizontalAlignment(SwingConstants.CENTER);
		   lblSnakeGame.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		   lblSnakeGame.setBounds(648, 35, 200, 60);
		   Snakeframe.getContentPane().add(lblSnakeGame);
		   
		   JLabel lblTime = new JLabel("time:");
		   lblTime.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblTime.setBounds(628, 192, 84, 30);
		   Snakeframe.getContentPane().add(lblTime);
		   
		   JLabel lblScore = new JLabel("score:");
		   lblScore.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblScore.setBounds(628, 258, 69, 20);
		   Snakeframe.getContentPane().add(lblScore);
		   
		   JLabel lblLives = new JLabel("lives:");
		   lblLives.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblLives.setBounds(628, 320, 69, 20);
		   Snakeframe.getContentPane().add(lblLives);
		   
		   JButton btnNewGame = new JButton("new game");
		   btnNewGame.setBackground(SystemColor.menu);
		   btnNewGame.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		SnakeView s=new SnakeView();
		   		s.Snakeframe.setVisible(true);
		   		Snakeframe.dispose();
		   	}
		   });
		   btnNewGame.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		   btnNewGame.setBounds(693, 539, 143, 37);
		   Snakeframe.getContentPane().add(btnNewGame);
		   
		   JButton btnNewButton = new JButton("Instructions");
		   btnNewButton.setBackground(SystemColor.menu);
		   btnNewButton.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		Instructions I = new Instructions();
		   		I.Instructionsframe.setVisible(true);
		   	//	Snakeframe.dispose();
		   	}
		   });
		   btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		   btnNewButton.setBounds(693, 486, 143, 37);
		   Snakeframe.getContentPane().add(btnNewButton);
		   
		   JLabel lblPressSpaceFor = new JLabel("press space for pause the game !");
		   lblPressSpaceFor.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		   lblPressSpaceFor.setBounds(628, 416, 273, 54);
		   Snakeframe.getContentPane().add(lblPressSpaceFor);
		   
		   JLabel lblPressEscFor = new JLabel("press esc for exit !");
		   lblPressEscFor.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		   lblPressEscFor.setBounds(628, 357, 273, 54);
		   Snakeframe.getContentPane().add(lblPressEscFor);
		   
		   JLabel lblName = new JLabel("Name:");
		   lblName.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblName.setBounds(628, 130, 84, 30);
		   Snakeframe.getContentPane().add(lblName);
		   
		   JLabel Namelabel = new JLabel("");
		   Namelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   Namelabel.setBounds(735, 164, 113, 24);
		   Snakeframe.getContentPane().add(Namelabel);
		   
		   JLabel timelabel = new JLabel("");
		   timelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   timelabel.setBounds(735, 226, 113, 24);
		   Snakeframe.getContentPane().add(timelabel);
		   
		   JLabel scorelabel = new JLabel("");
		   scorelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   scorelabel.setBounds(735, 286, 113, 24);
		   Snakeframe.getContentPane().add(scorelabel);
		   
		   JLabel livelabel = new JLabel("3");
		   livelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   livelabel.setBounds(734, 320, 69, 20);
		   Snakeframe.getContentPane().add(livelabel);
	}
}
