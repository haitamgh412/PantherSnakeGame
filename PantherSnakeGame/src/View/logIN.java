package View;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import Controller.SysData;
import Model.Board;
import Model.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class logIN {

	public JFrame loginframe;
	private JTextField Nametext;


	/**
	 * Create the application.
	 */
	public logIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginframe = new JFrame();
		loginframe.setResizable(false);
		loginframe.setIconImage(Toolkit.getDefaultToolkit().getImage(logIN.class.getResource("/images/icon.png")));
		loginframe.setTitle("SnakeGame");
		loginframe.setBounds(100, 100, 676, 452);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.getContentPane().setLayout(null);
		Board.playerScore = 0;
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen f = new MainScreen();
				f.framefirst.setVisible(true);
				loginframe.dispose();	
			
			}
		});
		btnNewButton.setIcon(new ImageIcon(logIN.class.getResource("/images/back.jpg")));
		btnNewButton.setBounds(30, 343, 67, 37);
		loginframe.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Name");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(201, 94, 212, 40);
		loginframe.getContentPane().add(lblNewLabel_1);
		
		Nametext = new JTextField();
		Nametext.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		Nametext.setBounds(183, 150, 230, 37);
		loginframe.getContentPane().add(Nametext);
		Nametext.setColumns(10);
		 
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Nametext.getText().equals("")) {
					JOptionPane.showMessageDialog(loginframe,"please enter your name !");
				}
				else {
					Player p = new Player(Nametext.getText());
					if(!SysData.getInstance().checkIfPlayerExist(p)) {
						SysData.getInstance().writePlayers(p);
					}
					SnakeView S = new SnakeView(Nametext.getText());
					S.Snakeframe.setVisible(true);
					loginframe.dispose();
				}
			}
		});
		
		
		btnPlay.setForeground(Color.BLACK);
		btnPlay.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		btnPlay.setBackground(new Color(154, 205, 50));
		btnPlay.setBounds(226, 212, 144, 40);
		loginframe.getContentPane().add(btnPlay);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(logIN.class.getResource("/images/snake111.jpg")));
		lblNewLabel.setBounds(0, 0, 655, 406);
		loginframe.getContentPane().add(lblNewLabel);
	}
	
}
