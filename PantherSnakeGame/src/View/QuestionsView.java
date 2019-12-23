package View;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

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
		Qframe.setTitle("Question");
		Qframe.setIconImage(Toolkit.getDefaultToolkit().getImage(QuestionsView.class.getResource("/images/write.png")));
		Qframe.setBounds(100, 100, 615, 420);
		Qframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Qframe.getContentPane().setLayout(null);
		
		JButton btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.setBackground(Color.WHITE);
		btnAddQuestion.setBounds(75, 62, 169, 43);
		Qframe.getContentPane().add(btnAddQuestion);
		
		JButton btnRemovQuestion = new JButton("Remov Question");
		btnRemovQuestion.setBackground(Color.WHITE);
		btnRemovQuestion.setBounds(75, 129, 169, 43);
		Qframe.getContentPane().add(btnRemovQuestion);
		
		JButton btnUpdateQuestion = new JButton("Update Question");
		btnUpdateQuestion.setBackground(Color.WHITE);
		btnUpdateQuestion.setBounds(75, 201, 169, 43);
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
		button.setBounds(15, 319, 60, 29);
		Qframe.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(QuestionsView.class.getResource("/images/panther.png")));
		label.setBounds(259, 0, 334, 365);
		Qframe.getContentPane().add(label);
	}
}
