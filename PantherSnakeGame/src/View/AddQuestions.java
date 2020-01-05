package View;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.SysData;
import Model.Question;
import Model.RedQuestion;
import Model.WhiteQuestion;
import Model.YellowQuestion;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddQuestions {

	public JFrame Addframe;
	private JTextField queTxt;
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JTextField ans4;


	/**
	 * Create the application.
	 */
	public AddQuestions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Addframe = new JFrame();
		Addframe.getContentPane().setBackground(Color.WHITE);
		Addframe.getContentPane().setLayout(null);

		JLabel lblAddQuistion = new JLabel("Add Question");
		lblAddQuistion.setBounds(340, 24, 103, 28);
		Addframe.getContentPane().add(lblAddQuistion);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblQuestion.setBounds(28, 77, 103, 20);
		Addframe.getContentPane().add(lblQuestion);

		JLabel lblAnswer = new JLabel("Answer 1 ");
		lblAnswer.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer.setBounds(28, 122, 122, 21);
		Addframe.getContentPane().add(lblAnswer);

		JLabel lblAnswer_1 = new JLabel("Answer 2");
		lblAnswer_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_1.setBounds(28, 166, 103, 21);
		Addframe.getContentPane().add(lblAnswer_1);

		JLabel lblAnswer_2 = new JLabel("Answer 3");
		lblAnswer_2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_2.setBounds(28, 216, 103, 21);
		Addframe.getContentPane().add(lblAnswer_2);

		JLabel lblAnswer_3 = new JLabel("Answer 4");
		lblAnswer_3.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_3.setBounds(28, 263, 103, 21);
		Addframe.getContentPane().add(lblAnswer_3);

		JLabel lblCurrectAnswer = new JLabel("Currect answer");
		lblCurrectAnswer.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblCurrectAnswer.setBounds(28, 312, 147, 21);
		Addframe.getContentPane().add(lblCurrectAnswer);

		JLabel lblLevel = new JLabel("Difficulty level");
		lblLevel.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblLevel.setBounds(28, 342, 122, 21);
		Addframe.getContentPane().add(lblLevel);

		queTxt = new JTextField();
		queTxt.setBounds(143, 77, 185, 22);
		Addframe.getContentPane().add(queTxt);
		queTxt.setColumns(10);

		ans1 = new JTextField();
		ans1.setBounds(143, 122, 185, 22);
		Addframe.getContentPane().add(ans1);
		ans1.setColumns(10);

		ans2 = new JTextField();
		ans2.setBounds(143, 165, 185, 22);
		Addframe.getContentPane().add(ans2);
		ans2.setColumns(10);

		ans3 = new JTextField();
		ans3.setBounds(143, 216, 185, 22);
		Addframe.getContentPane().add(ans3);
		ans3.setColumns(10);

		ans4 = new JTextField();
		ans4.setBounds(143, 263, 185, 22);
		Addframe.getContentPane().add(ans4);
		ans4.setColumns(10);

		ButtonGroup G = new ButtonGroup();
		JRadioButton level1 = new JRadioButton("1");
		level1.setBackground(Color.WHITE);
		level1.setBounds(163, 341, 47, 25);
		Addframe.getContentPane().add(level1);

		JRadioButton level2 = new JRadioButton("2");
		level2.setBackground(Color.WHITE);
		level2.setBounds(214, 341, 47, 25);
		Addframe.getContentPane().add(level2);

		JRadioButton level3 = new JRadioButton("3");
		level3.setBackground(Color.WHITE);
		level3.setBounds(262, 342, 47, 25);
		Addframe.getContentPane().add(level3);
		Addframe.setBounds(100, 100, 735, 477);
		Addframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		G.add(level1);
		G.add(level2);
		G.add(level3);

		ButtonGroup G2 = new ButtonGroup();
		JRadioButton currect1 = new JRadioButton("1");
		currect1.setBackground(Color.WHITE);
		currect1.setBounds(163, 311, 47, 25);
		Addframe.getContentPane().add(currect1);

		JRadioButton currect2 = new JRadioButton("2");
		currect2.setBackground(Color.WHITE);
		currect2.setBounds(207, 311, 47, 25);
		Addframe.getContentPane().add(currect2);

		JRadioButton currect3 = new JRadioButton("3");
		currect3.setBackground(Color.WHITE);
		currect3.setBounds(262, 311, 47, 25);
		Addframe.getContentPane().add(currect3);

		JRadioButton currect4 = new JRadioButton("4");
		currect4.setBackground(Color.WHITE);
		currect4.setBounds(311, 311, 47, 25);
		Addframe.getContentPane().add(currect4);

		G2.add(currect1);
		G2.add(currect2);
		G2.add(currect3);
		G2.add(currect4);

		JButton btnAdd = new JButton("Add Question");
		btnAdd.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String question = queTxt.getText();
				String answer1 = ans1.getText();
				String answer2 = ans2.getText();
				String answer3 = ans3.getText();
				String answer4 = ans4.getText();

				if(question==null || answer1==null || answer2==null ||answer3==null ||answer4==null) {
					JOptionPane.showMessageDialog(null, "Please enter all the fields");
					return;
				}

				if(!currect1.isSelected() && !currect2.isSelected() && !currect3.isSelected() && !currect4.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please select the number of currect answer");
					return;
				}
				int curreectAnsw ;
				if(currect1.isSelected())
					curreectAnsw=1;
				else if(currect2.isSelected())
					curreectAnsw=2;
				else if(currect3.isSelected())
					curreectAnsw=3;
				else
					curreectAnsw=4;

				if(!level1.isSelected() && !level2.isSelected() && !level3.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please select the difficulty level");
					return;
				}

				Question q = new Question();
				if(level1.isSelected())
					q= new WhiteQuestion(question, curreectAnsw, "Panther");
				else if(level2.isSelected())
					q= new YellowQuestion(question, curreectAnsw, "Panther");
				else
					q= new RedQuestion(question, curreectAnsw, "Panther");

				ArrayList<String> arr = new ArrayList<String>();
				arr.add(answer1);
				arr.add(answer2);
				arr.add(answer3);
				arr.add(answer4);

				q.setAnswers(arr);

				SysData.getInstance().writeQuestions(q);

				for(Question qqq : SysData.getInstance().getQuestionsAfterRead()) {
					if(qqq.getQuestion().equals(q.getQuestion())) {
						JOptionPane.showMessageDialog(null, "The question added successfully");
						return;
					}
				}

				JOptionPane.showMessageDialog(null, "Failed to add the question");
				return;

			}
		});
		btnAdd.setBounds(120, 375, 159, 42);
		Addframe.getContentPane().add(btnAdd);
	}
}