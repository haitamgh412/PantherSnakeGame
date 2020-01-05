package View;



import javax.swing.JFrame;
import Model.Board;
import Model.Player;
import Model.Question;
import Model.RedQuestion;
import Model.WhiteQuestion;
import Model.YellowQuestion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.SysData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class SnakeView {

	public JFrame Snakeframe;
    public String newName ; 
    public static JLabel scorelabel;
    public static JLabel livelabel;
    public static JLabel timeLabel;
	/**
	 * Create the application.
	 */
	public SnakeView(String name) {
	   this.newName = name ;
		initialize(newName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name) {
		Snakeframe = new JFrame();
		Snakeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Snakeframe.setResizable(false);
		Snakeframe.setForeground(new Color(204, 255, 204));
		Snakeframe.setBackground(new Color(255, 255, 255));
		Snakeframe.setIconImage(Toolkit.getDefaultToolkit().getImage(SnakeView.class.getResource("/images/icon.png")));
		Snakeframe.getContentPane().setBackground(new Color(255, 255, 255));
		Snakeframe.setTitle("SnakeGame_panther");
		Snakeframe.setBounds(100, 100, 999, 680);
		Snakeframe.getContentPane().setLayout(null);
		
		if (Board.isGameOver) {
			Board.setGameOver(false);
			//Board.setInGame(false);
			Board newBoard = new Board();
			 newBoard.setBackground(new Color(204, 255, 204));
			 newBoard.setBounds(0, 0, 600, 600);
			   Snakeframe.getContentPane().add(newBoard);
			   newBoard.setLayout(null);	
		}
		Board board = new Board();
		 board.setBackground(new Color(250, 235, 215));
		 board.setBounds(0, 0, 610, 610);
		   Snakeframe.getContentPane().add(board);
		   board.setLayout(null);
		
		
		   
		   JLabel lblSnakeGame = new JLabel("Snake Game ");
		   lblSnakeGame.setHorizontalAlignment(SwingConstants.CENTER);
		   lblSnakeGame.setFont(new Font("Segoe Print", Font.PLAIN, 24));
		   lblSnakeGame.setBounds(648, 35, 200, 60);
		   Snakeframe.getContentPane().add(lblSnakeGame);
		   
		   JLabel lblScore = new JLabel("score:");
		   lblScore.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblScore.setBounds(628, 195, 69, 20);
		   Snakeframe.getContentPane().add(lblScore);
		   
		   JLabel lblLives = new JLabel("lives:");
		   lblLives.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblLives.setBounds(628, 320, 69, 20);
		   Snakeframe.getContentPane().add(lblLives);
		   
		   JLabel Namelabel = new JLabel("");
		   Namelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   Namelabel.setBounds(727, 133, 161, 27);
		   Namelabel.setText(newName);
		  
		  JButton btnNewGame = new JButton("new game"); 
		   
		   Snakeframe.getContentPane().add(Namelabel);		   
		   
		   btnNewGame.setBackground(SystemColor.menu);
		   btnNewGame.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		Player p = SysData.getInstance().getPlayer(name);
				p.addScore(Integer.parseInt(scorelabel.getText()));
				SysData.getInstance().updatePlayer(p);
		   		logIN log = new logIN();
		   		log.loginframe.setVisible(true);
		   		Snakeframe.dispose();
//		   		Board.playerScore=0;  		
		   	}
		   });
		   btnNewGame.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		   btnNewGame.setBounds(693, 492, 169, 37);
		   Snakeframe.getContentPane().add(btnNewGame);
		   
		   JLabel lblPressEscFor = new JLabel("press esc for exit !");
		   lblPressEscFor.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		   lblPressEscFor.setBounds(628, 357, 273, 54);
		   Snakeframe.getContentPane().add(lblPressEscFor);
		   
		   JLabel lblName = new JLabel("Name:");
		   lblName.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblName.setBounds(628, 130, 84, 30);
		   Snakeframe.getContentPane().add(lblName);
		

		    
		   scorelabel = new JLabel("");
		   scorelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   scorelabel.setBounds(727, 193, 113, 24);
		   Snakeframe.getContentPane().add(scorelabel);
		   scorelabel.setText(Integer.toString(Board.playerScore));

          
		   int live = board.getNumOFLifes();
		   String live1 = Integer.toString(live);
		   
		   livelabel = new JLabel("");
		   livelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   livelabel.setBounds(734, 320, 69, 20);
		   Snakeframe.getContentPane().add(livelabel);
		   livelabel.setText(live1);
		   
		   JButton btnPause = new JButton("back");
		   btnPause.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		Player p = SysData.getInstance().getPlayer(name);
				p.addScore(Integer.parseInt(scorelabel.getText()));
				SysData.getInstance().updatePlayer(p);
		   		MainScreen f = new MainScreen();
				f.framefirst.setVisible(true);
				Board.soundManger.stopSound();
				Snakeframe.dispose();	   		
		   	}
		   });
		   btnPause.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		   btnPause.setBackground(SystemColor.menu);
		   btnPause.setBounds(695, 549, 167, 37);
		   Snakeframe.getContentPane().add(btnPause);
		   
		   JLabel lblTime = new JLabel("Time:");
		   lblTime.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblTime.setBounds(628, 258, 69, 20);
		   Snakeframe.getContentPane().add(lblTime);
		   
		   int time = board.getTime();
		   String time1 = Integer.toString(time);
		   
		   timeLabel = new JLabel("");
		   timeLabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   timeLabel.setBounds(727, 256, 113, 24);
		   Snakeframe.getContentPane().add(timeLabel);
		   timeLabel.setText(time1);
		   
//		   JButton btnNewButton = new JButton("Instructions");
//		   btnNewButton.setBackground(SystemColor.menu);
//		 
//		   
//		   btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 18));
//		   btnNewButton.setBounds(693, 439, 169, 37);
//		   Snakeframe.getContentPane().add(/
		   
		   JLabel lblPressSpaceFor = new JLabel("press space for start/pause the game !");
		   lblPressSpaceFor.setForeground(new Color(107, 142, 35));
		   lblPressSpaceFor.setBounds(70, 596, 448, 44);
		   Snakeframe.getContentPane().add(lblPressSpaceFor);
		   lblPressSpaceFor.setFont(new Font("Segoe Print", Font.BOLD, 21));

	}
	
	public static void updatescore() {
		   scorelabel.setText(Integer.toString(Board.playerScore));
	}
	
	public static void updateLives() {
		if(Board.numOFLifes>0)livelabel.setText(Integer.toString(Board.numOFLifes));
		if(Board.numOFLifes==0)livelabel.setText(Integer.toString(0));
	}
	
	public static void updateTime() {
		   timeLabel.setText(Integer.toString(Board.timer1));
		   
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public static JLabel getScorelabel() {
		return scorelabel;
	}

	public static void setScorelabel(JLabel scorelabel) {
		SnakeView.scorelabel = scorelabel;
	}
	
	public static void viewQuestion(Question Q) {
		if(Q instanceof RedQuestion ) {
		 	
		}
		if( Q instanceof YellowQuestion) {
			
		}
		if(Q instanceof WhiteQuestion) {
			
		}
		
	}
	
}
