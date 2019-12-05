
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
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class Setting extends JFrame implements ActionListener {

	private JMenuBar menuBar = null;
	private JMenu fileMenu = null;

	private JMenuItem newGameMenuItem = null;
	private JMenuItem exitGameMenuItem = null;
	private JTextField txtSankeGame;
	private JTextField txtPantherTeam;


	
	public Setting(int level) {
		getContentPane().setFont(new Font("Yu Gothic Medium", Font.BOLD, 26));
		getContentPane().setForeground(new Color(255, 255, 0));
		getContentPane().setBackground(new Color(0, 0, 0));
		
		setType(Type.POPUP);
		setFont(new Font("Dialog", Font.BOLD, 13));
		setForeground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\haita\\eclipse-workspace\\TestSankeGame\\src\\images\\sound.png"));
		setTitle("Snake Game - Setting");
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
		getContentPane().setLayout(null);
		
		txtSankeGame = new JTextField();
		txtSankeGame.setForeground(new Color(255, 255, 51));
		txtSankeGame.setFont(new Font("Tempus Sans ITC", Font.BOLD, 46));
		txtSankeGame.setBackground(new Color(0, 0, 0));
		txtSankeGame.setText("Sanke Game");
		txtSankeGame.setBounds(34, 20, 517, 56);
		getContentPane().add(txtSankeGame);
		txtSankeGame.setColumns(10);
		
		txtPantherTeam = new JTextField();
		txtPantherTeam.setFont(new Font("Urdu Typesetting", Font.BOLD, 44));
		txtPantherTeam.setForeground(new Color(255, 255, 51));
		txtPantherTeam.setBackground(new Color(0, 0, 0));
		txtPantherTeam.setText("Panther Team ");
		txtPantherTeam.setBounds(282, 96, 269, 66);
		getContentPane().add(txtPantherTeam);
		txtPantherTeam.setColumns(10);
		
		JCheckBox chckbxOnOff = new JCheckBox("ON / OFF Sound ");
		chckbxOnOff.setToolTipText("");
		chckbxOnOff.setSelected(true);
		chckbxOnOff.setForeground(new Color(0, 255, 51));
		chckbxOnOff.setFont(new Font("Tahoma", Font.BOLD, 38));
		chckbxOnOff.setBackground(new Color(0, 0, 0));
		chckbxOnOff.setBounds(34, 366, 449, 66);
		getContentPane().add(chckbxOnOff);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\haita\\eclipse-workspace\\TestSankeGame\\src\\images\\snake2.png"));
		label.setBounds(20, 96, 246, 264);
		getContentPane().add(label);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		if (source == newGameMenuItem) {
			
			setVisible(false);
			dispose();
			new MainScreen(1);
		}

		if (source == exitGameMenuItem) {
			System.exit(0);
		}

	}
}