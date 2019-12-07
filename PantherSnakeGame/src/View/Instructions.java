
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class Instructions extends JFrame implements ActionListener {

	private JMenuBar menuBar = null;
	private JMenu fileMenu = null;

	private JMenuItem newGameMenuItem = null;
	private JMenuItem exitGameMenuItem = null;
	
	public Instructions(int level) {
		
		
		setType(Type.POPUP);
		setFont(new Font("Dialog", Font.BOLD, 13));
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Instructions.class.getResource("/images/instructionss.png")));
		setTitle("Snake Game - Panther Team");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1100, 700);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 127, 600, 500);
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		fileMenu.setBackground(new Color(0, 0, 0));
		fileMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		fileMenu.setForeground(new Color(0, 0, 0));
		fileMenu.setIcon(null);
		fileMenu.setSelectedIcon(null);

		newGameMenuItem = new JMenuItem("Back");
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
			setVisible(false);
			dispose();

			new MainScreen();
		}

		if (source == exitGameMenuItem) {
			System.exit(0);
		}

	}
}