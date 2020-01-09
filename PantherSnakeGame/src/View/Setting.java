package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Setting {

	public JFrame Settingframe;
	public static boolean sound = true;
	public static boolean sound1 = true;

	/**
	 * Create the application.
	 */
	public Setting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Settingframe = new JFrame();
		Settingframe.setResizable(false);
		Settingframe.setTitle("Settings");
		Settingframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Setting.class.getResource("/images/settings.png")));
		Settingframe.getContentPane().setBackground(Color.WHITE);
		Settingframe.setBackground(Color.WHITE);
		Settingframe.setBounds(100, 100, 631, 513);
		Settingframe.getContentPane().setLayout(null);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setFont(new Font("Segoe Print", Font.BOLD, 30));
		lblSettings.setBounds(247, 119, 165, 53);
		Settingframe.getContentPane().add(lblSettings);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreen f = new MainScreen();
				f.framefirst.setVisible(true);
				Settingframe.dispose();	
				
			}
		});
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(Setting.class.getResource("/images/esc1.jpg")));
		button.setBounds(15, 399, 49, 42);
		Settingframe.getContentPane().add(button);
		
		JCheckBox chckbxOnoff = new JCheckBox("On/Off");
		chckbxOnoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 sound = false;
			}
		});
		sound = true;
		chckbxOnoff.setSelected(true);
		chckbxOnoff.setBackground(new Color(255, 255, 255));
		chckbxOnoff.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		chckbxOnoff.setBounds(362, 200, 139, 29);
		Settingframe.getContentPane().add(chckbxOnoff);
		
		JCheckBox checkBox = new JCheckBox("On/Off");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 sound1 = false;
			}
		});
		sound1 = true;
		checkBox.setSelected(true);
		checkBox.setBackground(new Color(255, 255, 255));
		checkBox.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		checkBox.setBounds(362, 270, 139, 29);
		Settingframe.getContentPane().add(checkBox);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Setting.class.getResource("/images/music.png")));
		label_2.setBounds(194, 200, 42, 29);
		Settingframe.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Setting.class.getResource("/images/sound.png")));
		label_3.setBounds(194, 279, 69, 20);
		Settingframe.getContentPane().add(label_3);
		
		JButton btnUpdateQuestions = new JButton("update questions");
		btnUpdateQuestions.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnUpdateQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QuestionsView V = new QuestionsView();
				V.Qframe.setVisible(true);
				Settingframe.dispose();	
				
			}
		});
		btnUpdateQuestions.setBackground(new Color(255, 255, 240));
		btnUpdateQuestions.setBounds(333, 346, 174, 43);
		Settingframe.getContentPane().add(btnUpdateQuestions);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Setting.class.getResource("/images/whiteQ.png")));
		label.setBounds(197, 346, 32, 32);
		Settingframe.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Setting.class.getResource("/images/setting.jpg")));
		label_1.setBounds(0, -26, 426, 409);
		Settingframe.getContentPane().add(label_1);
	}
}
