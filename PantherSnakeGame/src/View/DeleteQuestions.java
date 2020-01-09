package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.SysData;
import Model.Question;
import Model.RedQuestion;
import Model.WhiteQuestion;
import Model.YellowQuestion;

public class DeleteQuestions {

	public JFrame removeframe;
	private JLabel ans1;
	private JLabel ans2;
	private JLabel ans3;
	private JLabel ans4;


	/**
	 * Create the application.
	 */
	public DeleteQuestions() {
		initialize();
	}


	public void initialize() {
		removeframe = new JFrame();
		removeframe.setBackground(Color.WHITE);
		removeframe.setIconImage(Toolkit.getDefaultToolkit().getImage(AddQuestions.class.getResource("/images/write.png")));
		removeframe.setTitle("deleteQuestion");
		removeframe.setResizable(false);
		removeframe.getContentPane().setBackground(Color.WHITE);
		removeframe.getContentPane().setLayout(null);

		JLabel lblQuestion = new JLabel("Question :");
		lblQuestion.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblQuestion.setBounds(28, 37, 103, 28);
		removeframe.getContentPane().add(lblQuestion);

		JLabel lblAnswer = new JLabel("Answer 1 : ");
		lblAnswer.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer.setBounds(28, 93, 122, 21);
		removeframe.getContentPane().add(lblAnswer);

		JLabel lblAnswer_1 = new JLabel("Answer 2 :");
		lblAnswer_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_1.setBounds(28, 145, 103, 21);
		removeframe.getContentPane().add(lblAnswer_1);

		JLabel lblAnswer_2 = new JLabel("Answer 3 :");
		lblAnswer_2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_2.setBounds(28, 204, 103, 21);
		removeframe.getContentPane().add(lblAnswer_2);

		JLabel lblAnswer_3 = new JLabel("Answer 4 :");
		lblAnswer_3.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_3.setBounds(28, 256, 103, 21);
		removeframe.getContentPane().add(lblAnswer_3);

		JLabel lblCurrectAnswer = new JLabel("Currect answer :");
		lblCurrectAnswer.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblCurrectAnswer.setBounds(28, 312, 147, 21);
		removeframe.getContentPane().add(lblCurrectAnswer);

		JLabel labelll = new JLabel("Difficulty level :");
		labelll.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		labelll.setBounds(28, 347, 147, 21);
		removeframe.getContentPane().add(labelll);

		ans1 = new JLabel();
		ans1.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans1.setBounds(143, 85, 422, 36);
		removeframe.getContentPane().add(ans1);


		ans2 = new JLabel();
		ans2.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans2.setBounds(143, 137, 422, 36);
		removeframe.getContentPane().add(ans2);


		ans3 = new JLabel();
		ans3.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans3.setBounds(143, 196, 422, 36);
		removeframe.getContentPane().add(ans3);


		ans4 = new JLabel();
		ans4.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans4.setBounds(143, 248, 422, 36);
		removeframe.getContentPane().add(ans4);


		ButtonGroup G = new ButtonGroup();
		removeframe.setBounds(100, 100, 735, 477);
		removeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup G2 = new ButtonGroup();

		JButton btnremove = new JButton("Remove Question");

		btnremove.setBackground(Color.WHITE);
		btnremove.setFont(new Font("Segoe Print", Font.PLAIN, 16));


		btnremove.setBounds(301, 382, 185, 42);
		removeframe.getContentPane().add(btnremove);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddQuestions.class.getResource("/images/Question.jpg")));
		label.setBounds(526, 216, 203, 221);
		removeframe.getContentPane().add(label);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				QuestionsView Q = new QuestionsView();
				Q.Qframe.setVisible(true);
				removeframe.dispose();
			}
		});
		button.setIcon(new ImageIcon(AddQuestions.class.getResource("/images/back.jpg")));
		button.setBounds(35, 392, 56, 29);
		removeframe.getContentPane().add(button);

		JComboBox quesCombo = new JComboBox();
		quesCombo.setBackground(Color.WHITE);
		quesCombo.setBounds(143, 41, 422, 28);
		for(Question q : SysData.getInstance().getQuestionsssss())
			quesCombo.addItem(q.getQuestion());
		
		JLabel lblCurrectAnsw = new JLabel();
		lblCurrectAnsw.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		lblCurrectAnsw.setBounds(181, 315, 56, 16);
		removeframe.getContentPane().add(lblCurrectAnsw);
		
		JLabel lblLevel = new JLabel();
		lblLevel.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		lblLevel.setBounds(170, 350, 56, 16);
		removeframe.getContentPane().add(lblLevel);

		
		Question question = SysData.getInstance().getSpecificQuestion(quesCombo.getSelectedItem().toString());
		ans1.setText(question.getAnswers().get(0));
		ans2.setText(question.getAnswers().get(1));
		ans3.setText(question.getAnswers().get(2));
		ans4.setText(question.getAnswers().get(3));

		if(question.getCurrectAnsw()==1)
			lblCurrectAnsw.setText("1"); 
		else if(question.getCurrectAnsw()==2)
			lblCurrectAnsw.setText("2");
		else if(question.getCurrectAnsw()==3)
			lblCurrectAnsw.setText("3");
		else
			lblCurrectAnsw.setText("4");

		if(question.getClass().getSimpleName().equals("WhiteQuestion"))
			lblLevel.setText("1");
		else if(question.getClass().getSimpleName().equals("YellowQuestion"))
			lblLevel.setText("2");
		else
			lblLevel.setText("3");
		removeframe.getContentPane().add(quesCombo);
		


		quesCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Question question = SysData.getInstance().getSpecificQuestion(quesCombo.getSelectedItem().toString());
				ans1.setText(question.getAnswers().get(0));
				ans2.setText(question.getAnswers().get(1));
				ans3.setText(question.getAnswers().get(2));
				ans4.setText(question.getAnswers().get(3));

				if(question.getCurrectAnsw()==1)
					lblCurrectAnsw.setText("1"); 
				else if(question.getCurrectAnsw()==2)
					lblCurrectAnsw.setText("2");
				else if(question.getCurrectAnsw()==3)
					lblCurrectAnsw.setText("3");
				else
					lblCurrectAnsw.setText("4");

				if(question.getClass().getSimpleName().equals("WhiteQuestion"))
					lblLevel.setText("1");
				else if(question.getClass().getSimpleName().equals("YellowQuestion"))
					lblLevel.setText("2");
				else
					lblLevel.setText("3");
			}

		});

		btnremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String question = quesCombo.getSelectedItem().toString();
				String answer1 = ans1.getText();
				String answer2 = ans2.getText();
				String answer3 = ans3.getText();
				String answer4 = ans4.getText();


				int curreectAnsw = Integer.parseInt(lblCurrectAnsw.getText());
				

				Question q = new Question();
				int level = Integer.parseInt(lblLevel.getText());
				if(level ==1)
					q= new WhiteQuestion(question, curreectAnsw, "Panther");
				else if(level ==2)
					q= new YellowQuestion(question, curreectAnsw, "Panther");
				else
					q= new RedQuestion(question, curreectAnsw, "Panther");

				ArrayList<String> arr = new ArrayList<String>();
				arr.add(answer1);
				arr.add(answer2);
				arr.add(answer3);
				arr.add(answer4);

				q.setAnswers(arr);
				if(SysData.getInstance().RemoveQuestion(q)) {
					quesCombo.removeItem(quesCombo.getSelectedItem());
					JOptionPane.showMessageDialog(null, "The question removed successfully");
					return;
				}

	      	 
				JOptionPane.showMessageDialog(null, "Failed to remove the question");
				return;
				
			}
		});

	}
}