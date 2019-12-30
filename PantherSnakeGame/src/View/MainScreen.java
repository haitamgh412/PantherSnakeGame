package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainScreen  extends JFrame implements ActionListener {

	public JFrame framefirst;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.framefirst.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framefirst = new JFrame();
		framefirst.setTitle("SnakeGame");
		framefirst.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/images/icon.png")));
		framefirst.setBounds(100, 100, 669, 459);
		framefirst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framefirst.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				setVisible(false);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(MainScreen.class.getResource("/images/esc1.jpg")));
		btnNewButton.setBounds(26, 341, 42, 46);
		framefirst.getContentPane().add(btnNewButton);
		
		JButton btnHightScore = new JButton("Hight Score");
		btnHightScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HighScores H = new HighScores();
				H.scoreframe.setVisible(true);
				framefirst.dispose();
			}
		});
		btnHightScore.setForeground(Color.BLACK);
		btnHightScore.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		btnHightScore.setBackground(new Color(154, 205, 50));
		btnHightScore.setBounds(213, 292, 144, 40);
		framefirst.getContentPane().add(btnHightScore);
		
		JButton btnIns = new JButton("Instructions");
		btnIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructions I =  new Instructions();
				I.Instructionsframe.setVisible(true);
				setVisible(false);
					dispose();
			}
		});
		btnIns.setForeground(Color.BLACK);
		btnIns.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		btnIns.setBackground(new Color(154, 205, 50));
		btnIns.setBounds(213, 229, 144, 40);
		framefirst.getContentPane().add(btnIns);
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Setting S = new Setting();
				S.Settingframe.setVisible(true);
				framefirst.dispose();
			}
		});
		btnSetting.setForeground(Color.BLACK);
		btnSetting.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		btnSetting.setBackground(new Color(154, 205, 50));
		btnSetting.setBounds(213, 165, 144, 40);
		framefirst.getContentPane().add(btnSetting);
		
		JLabel lblSnakeGamePanther = new JLabel("Snake Game_Panther");
		lblSnakeGamePanther.setFont(new Font("Segoe Print", Font.ITALIC, 35));
		lblSnakeGamePanther.setBounds(91, 13, 450, 68);
		framefirst.getContentPane().add(lblSnakeGamePanther);
		
		JButton button1 = new JButton("Log IN");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    
		    logIN N = new logIN();
			N.loginframe.setVisible(true);
			framefirst.dispose();
		    
			}
		});
		button1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		button1.setBackground(new Color(154, 205, 50));
		button1.setForeground(new Color(0, 0, 0));
		button1.setBounds(213, 97, 144, 40);
		framefirst.getContentPane().add(button1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/images/snake111.jpg")));
		lblNewLabel.setBounds(0, -20, 672, 436);
		framefirst.getContentPane().add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
