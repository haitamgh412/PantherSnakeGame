
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Model.GameBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class GameBoardWindow extends JFrame implements ActionListener {

	private JMenuBar menuBar = null;
	private JMenu fileMenu = null;

	private JMenuItem newGameMenuItem = null;
	private JMenuItem exitGameMenuItem = null;
	
	public GameBoardWindow(int level) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\icon.png"));
		
		setTitle("Snake Game - Panther");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1200, 700);
		setResizable(false);

		getContentPane().add(new GameBoard(level));
		
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		fileMenu.setBackground(new Color(0, 0, 0));
		fileMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		fileMenu.setForeground(new Color(0, 0, 0));
		fileMenu.setIcon(null);
		fileMenu.setSelectedIcon(null);

		newGameMenuItem = new JMenuItem("New Game");
		exitGameMenuItem = new JMenuItem("Exit");

		fileMenu.add(newGameMenuItem);
		fileMenu.add(exitGameMenuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		newGameMenuItem.addActionListener(this);
		exitGameMenuItem.addActionListener(this);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		if (source == newGameMenuItem) {
			 logIN N = new logIN();
				N.loginframe.setVisible(true);
			
			dispose();

		}

		if (source == exitGameMenuItem) {
			System.exit(0);
		}

	}
}
