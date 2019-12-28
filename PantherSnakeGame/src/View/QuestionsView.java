package View;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class QuestionsView {

	public JFrame Qframe;



	/**
	 * Create the application.
	 */
	public QuestionsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Qframe = new JFrame();
		Qframe.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		Qframe.setTitle("Question");
		Qframe.setIconImage(Toolkit.getDefaultToolkit().getImage(QuestionsView.class.getResource("/images/write.png")));
		Qframe.setBounds(100, 100, 615, 465);
		Qframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Qframe.getContentPane().setLayout(null);
		
		JButton btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnAddQuestion.setBackground(Color.WHITE);
		btnAddQuestion.setBounds(75, 83, 192, 50);
		Qframe.getContentPane().add(btnAddQuestion);
		
		JButton btnRemovQuestion = new JButton("Remove Question");
		btnRemovQuestion.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnRemovQuestion.setBackground(Color.WHITE);
		btnRemovQuestion.setBounds(75, 159, 192, 50);
		Qframe.getContentPane().add(btnRemovQuestion);
		
		JButton btnUpdateQuestion = new JButton("Update Question");
		btnUpdateQuestion.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnUpdateQuestion.setBackground(Color.WHITE);
		btnUpdateQuestion.setBounds(75, 247, 192, 50);
		Qframe.getContentPane().add(btnUpdateQuestion);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreen f = new MainScreen();
				f.framefirst.setVisible(true);
				Qframe.dispose();	
			}
		});
		button.setIcon(new ImageIcon(QuestionsView.class.getResource("/images/back.jpg")));
		button.setBounds(15, 364, 60, 29);
		Qframe.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Downloads\\think.png"));
		label.setBounds(0, 0, 593, 409);
		Qframe.getContentPane().add(label);
	}
}
