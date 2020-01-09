package View;


import javax.swing.JFrame;
import Model.Board;
import Model.Player;
import Model.Question;
import Model.RedQuestion;
import Model.WhiteQuestion;
import Model.YellowQuestion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

import Controller.SysData;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class SnakeView {

	public static JFrame Snakeframe;
    public String newName ; 
    public static JLabel scorelabel;
    public static JLabel livelabel;
    public static String name1;
    public static  JLabel lblQ;
    public static JRadioButton choice1, choice2, choice3,choice4;
    public static JPanel panel2;
    public static ButtonGroup group ; 
    static int starttime=(int) System.currentTimeMillis();
   
    public static int i = 0;
	public static int k = 0;
	public static int g = 0;

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
	@SuppressWarnings("static-access")
	private void initialize(String name) {
		this.name1=name;
		Snakeframe = new JFrame();
		Snakeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Snakeframe.setResizable(false);
		Snakeframe.setForeground(new Color(255, 255, 255));
		Snakeframe.setBackground(new Color(255, 255, 255));
		Snakeframe.setIconImage(Toolkit.getDefaultToolkit().getImage(SnakeView.class.getResource("/images/icon.png")));
		Snakeframe.getContentPane().setBackground(new Color(255, 255, 255));
		Snakeframe.setTitle("SnakeGame_panther");
		Snakeframe.setBounds(100, 100, 999, 680);
		Snakeframe.getContentPane().setLayout(null);
		
		if (Board.isGameOver) {
			Board.setGameOver(false);
			Board newBoard = new Board();
			 newBoard.setBackground(new Color(0, 51, 0));
			 newBoard.setBounds(0, 0, 600, 600);
			   Snakeframe.getContentPane().add(newBoard);
			   newBoard.setLayout(null);	
		}
		Board board = new Board();
		 board.setBackground(new Color(51, 102, 51));
		 board.setBounds(0, 0, 610, 610);
		   Snakeframe.getContentPane().add(board);
		   board.setLayout(null);
		   
		   JLabel lblSnakeGame = new JLabel("Snake Game ");
		   lblSnakeGame.setHorizontalAlignment(SwingConstants.CENTER);
		   lblSnakeGame.setFont(new Font("Segoe Print", Font.PLAIN, 33));
		   lblSnakeGame.setBounds(648, 35, 285, 60);
		   Snakeframe.getContentPane().add(lblSnakeGame);
		   
		   JLabel lblScore = new JLabel("score:");
		   lblScore.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblScore.setBounds(628, 233, 69, 20);
		   Snakeframe.getContentPane().add(lblScore);
		   
		   JLabel lblLives = new JLabel("lives:");
		   lblLives.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblLives.setBounds(628, 292, 69, 20);
		   Snakeframe.getContentPane().add(lblLives);
		   
		   JLabel Namelabel = new JLabel("");
		   Namelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   Namelabel.setBounds(722, 179, 161, 27);
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
		   	}
		   });
		   btnNewGame.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		   btnNewGame.setBounds(693, 507, 169, 37);
		   Snakeframe.getContentPane().add(btnNewGame);
		   
		   JLabel lblPressEscFor = new JLabel("press esc for exit !");
		   lblPressEscFor.setForeground(new Color(107, 142, 35));
		   lblPressEscFor.setFont(new Font("Segoe Print", Font.BOLD, 16));
		   lblPressEscFor.setBounds(625, 348, 273, 54);
		   Snakeframe.getContentPane().add(lblPressEscFor);
		   
		   JLabel lblMaximumLives = new JLabel("maximum 3 lives !");
		   lblMaximumLives.setForeground(new Color(102, 153, 0));
		   lblMaximumLives.setFont(new Font("Segoe Print", Font.BOLD, 16));
		   lblMaximumLives.setBounds(625, 393, 273, 54);
		   Snakeframe.getContentPane().add(lblMaximumLives);
		   
		   JLabel lblName = new JLabel("Name:");
		   lblName.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   lblName.setBounds(620, 177, 84, 30);
		   Snakeframe.getContentPane().add(lblName);
		

		    
		   scorelabel = new JLabel("");
		   scorelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   scorelabel.setBounds(727, 231, 113, 24);
		   Snakeframe.getContentPane().add(scorelabel);
		   scorelabel.setText(Integer.toString(Board.playerScore));

          
		   int live = board.getNumOFLifes();
		   String live1 = Integer.toString(live);
		   
		   livelabel = new JLabel("");
		   livelabel.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		   livelabel.setBounds(727, 292, 69, 20);
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
		   btnPause.setBounds(693, 560, 167, 37);
		   Snakeframe.getContentPane().add(btnPause);
		   
		   JButton btnInstructions = new JButton("Instructions");
		   btnInstructions.setBackground(SystemColor.menu);
		   btnInstructions.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent arg0) {
		   		board.soundManger.pauseSound();
		   		board.timer.stop();
		   		Instructions1 i = new Instructions1();
		   		i.Iframe.setVisible(true);
		   		btnInstructions.setFocusable(false);
		   		btnNewGame.setFocusable(false);
		   		btnPause.setFocusable(false);
		   		
		   	}
		   });
		   btnInstructions.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		   btnInstructions.setBounds(693, 454, 169, 37);
		   Snakeframe.getContentPane().add(btnInstructions);
		   
		   
		   JLabel lblPressSpaceFor = new JLabel("press space for start/pause the game !");
		   lblPressSpaceFor.setForeground(new Color(107, 142, 35));
		   lblPressSpaceFor.setBounds(59, 596, 459, 44);
		   Snakeframe.getContentPane().add(lblPressSpaceFor);
		   lblPressSpaceFor.setFont(new Font("Segoe Print", Font.BOLD, 23));
		   
		   JLabel lblPanther = new JLabel("Panther");
		   lblPanther.setForeground(new Color(107, 142, 35));
		   lblPanther.setFont(new Font("Segoe Print", Font.BOLD, 22));
		   lblPanther.setBounds(739, 100, 113, 54);
		   Snakeframe.getContentPane().add(lblPanther);
		    
		   lblQ = new JLabel("");
		   panel2 = new JPanel(); 
		   choice1 = new JRadioButton();
		   choice2 = new JRadioButton();
		   choice3 = new JRadioButton();
		   choice4 = new JRadioButton();
		   group = new ButtonGroup(); 

	}
	
	/**
	 * prints game over in the center if the player used all the 3 lives
	 * and adds the name of the player to the json file
	 * @param g
	 */
	
    public static void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 28);

        g.setColor(Color.RED);
        g.setFont(small);
        g.drawString(msg, (Board.B_WIDTH ) / 3, Board.B_HEIGHT / 2);
        
        
   		Player p = SysData.getInstance().getPlayer(name1);
		p.addScore(Integer.parseInt(scorelabel.getText()));
		SysData.getInstance().updatePlayer(p);
		Board.soundManger.stopSound();
        
    }
    
    /**
     * update the score of the player in the board
     */
    
	
	public static void updatescore() {
		   scorelabel.setText(Integer.toString(Board.playerScore));
	}
	
	/**
	 * update the lives in the board
	 */
	
	public static void updateLives() {
		if(Board.numOFLifes>0)livelabel.setText(Integer.toString(Board.numOFLifes));
		if(Board.numOFLifes==0)livelabel.setText(Integer.toString(0));
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
	
	/**
	 * view the question in the board when the player eat the question icon (red/white/yellow)
	 * make a comparison to the answers of the question
	 * @param Q
	 * @return true answer in dialog if true
	 * else false answer dialog
	 */
	
	public static boolean viewQuestion(Question Q) {
		if(Q instanceof RedQuestion ) {	
		 int redSize = SysData.getInstance().getRedQues().size();
			if(i!=redSize) {
			 lblQ.setText(SysData.getInstance().getRedQues().get(i).getQuestion());
			   choice1.setText(SysData.getInstance().getRedQues().get(i).getAnswers().get(0));
			   choice2.setText(SysData.getInstance().getRedQues().get(i).getAnswers().get(1));
			   choice3.setText(SysData.getInstance().getRedQues().get(i).getAnswers().get(2));
			   choice4.setText(SysData.getInstance().getRedQues().get(i).getAnswers().get(3));
			   group.add(choice1);
			   group.add(choice2);
			   group.add(choice3);
			   group.add(choice4);
			   panel2.add(lblQ);
			   panel2.add(choice1);
			   panel2.add(choice2);
			   panel2.add(choice3);
			   panel2.add(choice4);
			   JOptionPane.showConfirmDialog(null, panel2, "Question", JOptionPane.PLAIN_MESSAGE); 
	      int answer = SysData.getInstance().getRedQues().get(i).getCurrectAnsw();
	      String cAnswer = SysData.getInstance().getRedQues().get(i).getAnswers().get(answer-1);
		   	 if (choice1.isSelected() && choice1.getText().equals(cAnswer)){
		   		i++;	
				JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
            }
		   	 else if (choice2.isSelected() && choice2.getText().equals(cAnswer)) {
		   		 i++;
					JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		return true;
		   	 }
		   	 else if (choice3.isSelected() && choice3.getText().equals(cAnswer)) {
		   		i++;
				JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }
		   	 else if (choice4.isSelected() && choice4.getText().equals(cAnswer)) {
		   		i++;
				JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }
		   	 else {i++;
		   	JOptionPane.showMessageDialog(Snakeframe,"false answer!");
		   	 }
		   	
			}
			else {
				i=0;
			}
		}
		else if( Q instanceof YellowQuestion) {
			int yellowSize = SysData.getInstance().getYelloweQues().size();
			if(k!=yellowSize) {
			lblQ.setText(SysData.getInstance().getYelloweQues().get(k).getQuestion());
			   choice1.setText(SysData.getInstance().getYelloweQues().get(k).getAnswers().get(0));
			   choice2.setText(SysData.getInstance().getYelloweQues().get(k).getAnswers().get(1));
			   choice3.setText(SysData.getInstance().getYelloweQues().get(k).getAnswers().get(2));
			   choice4.setText(SysData.getInstance().getYelloweQues().get(k).getAnswers().get(3));
			   group.add(choice1);
			   group.add(choice2);
			   group.add(choice3);
			   group.add(choice4);
			   panel2.add(lblQ);
			   panel2.add(choice1);
			   panel2.add(choice2);
			   panel2.add(choice3);
			   panel2.add(choice4);
			   JOptionPane.showConfirmDialog(null, panel2, "Question", JOptionPane.PLAIN_MESSAGE); 
	      int answer = SysData.getInstance().getYelloweQues().get(k).getCurrectAnsw();
	      String cAnswer = SysData.getInstance().getYelloweQues().get(k).getAnswers().get(answer-1);
		   	 if (choice1.isSelected() && choice1.getText().equals(cAnswer)){
		   		k++;
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
         }
		   	 else if (choice2.isSelected() && choice2.getText().equals(cAnswer)) {
		   		k++;
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }
		   	 else if (choice3.isSelected() && choice3.getText().equals(cAnswer)) {
		   		k++;
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }
		   	 else if (choice4.isSelected() && choice4.getText().equals(cAnswer)) {
		   		k++;
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }	
		   	 else {k++;
		   	JOptionPane.showMessageDialog(Snakeframe,"false answer!");
		   	 
		   	 }
			}
			else {
				k=0;
			}
		}
		else if(Q instanceof WhiteQuestion) {
			int whiteSize = SysData.getInstance().getWhiteQues().size();
			if(g!= whiteSize) {
			lblQ.setText(SysData.getInstance().getWhiteQues().get(g).getQuestion());
			   choice1.setText(SysData.getInstance().getWhiteQues().get(g).getAnswers().get(0));
			   choice2.setText(SysData.getInstance().getWhiteQues().get(g).getAnswers().get(1));
			   choice3.setText(SysData.getInstance().getWhiteQues().get(g).getAnswers().get(2));
			   choice4.setText(SysData.getInstance().getWhiteQues().get(g).getAnswers().get(3));
			   group.add(choice1);
			   group.add(choice2);
			   group.add(choice3);
			   group.add(choice4);
			   panel2.add(lblQ);
			   panel2.add(choice1);
			   panel2.add(choice2);
			   panel2.add(choice3);
			   panel2.add(choice4);
			   JOptionPane.showConfirmDialog(null, panel2, "Question", JOptionPane.PLAIN_MESSAGE); 
	      int answer = SysData.getInstance().getWhiteQues().get(g).getCurrectAnsw();
	      String cAnswer = SysData.getInstance().getWhiteQues().get(g).getAnswers().get(answer-1);
		   	 if (choice1.isSelected() && choice1.getText().equals(cAnswer)){
		   		g++;	
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
         }
		   	 else if (choice2.isSelected() && choice2.getText().equals(cAnswer)) {
		   		g++;
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }
		   	 else if (choice3.isSelected() && choice3.getText().equals(cAnswer)) {
		   		g++;
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }
		   	 else if (choice4.isSelected() && choice4.getText().equals(cAnswer)) {	 
		   		g++;
		   		JOptionPane.showMessageDialog(Snakeframe,"True answer!");
		   		 return true;
		   	 }
		   	 else {g++;
		   	JOptionPane.showMessageDialog(Snakeframe,"false answer!");
		   	 }
			}
			else {
				g=0;
			}
		   	   	
		}
		return false; 
		
	}
}
