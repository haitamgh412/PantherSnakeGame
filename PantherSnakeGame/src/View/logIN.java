package View;

import java.awt.Button;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class logIN extends JFrame implements ActionListener {

	private static final long serialVersionUID = -1299314404835604855L;

	Button list[] = new Button[3];
	String listStrings[] = { "New Game","Back", "Exit" };
	MainScreenPanel buttonPanel = null;

	public logIN(int level) {
		setResizable(false);
		setType(Type.POPUP);
		setFont(new Font("Dialog", Font.BOLD, 13));
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\icon.png"));
		setTitle("Snake Game - LogIN Page");
		
		buttonPanel = new MainScreenPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 127, 600, 500);
		buttonPanel.setBackground(Color.BLACK);
		for (int i = 0; i < list.length; i++) {
			list[i] = new Button(listStrings[i]);
			list[i].addActionListener(this);
			list[i].setBackground(Color.YELLOW);
			list[i].setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			list[i].setBounds(230, 200 + i * 50, 120, 30);
			buttonPanel.add(list[i]);
		}

		buttonPanel.setLayout(null);
		getContentPane().add(buttonPanel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == list[0]) {

			new GameBoardWindow(1);
			setVisible(false);
			dispose();

		}
		
		if (obj == list[1]) {
			
            new MainScreen(1);
			setVisible(false);
			dispose();
		}
		
		if (obj == list[2]) {

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(false);
			dispose();
		}
		
	}

	@SuppressWarnings("serial")
	class MainScreenPanel extends JPanel {

		MainScreenPanel() {
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
			g2.drawString("  Snake Game", 135, 85);
			g2.setColor(Color.YELLOW);
			g2.drawString("Panther", 210, 150);
		}
	}
}