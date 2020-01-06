package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.SysData;
import Model.Question;
import Model.RedQuestion;
import Model.WhiteQuestion;
import Model.YellowQuestion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UpdateQuestions{

	public JFrame updateframe;
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JTextField ans4;

	/**
	 * Create the application.
	 */
	public UpdateQuestions() {
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		updateframe = new JFrame();
		updateframe.setBackground(Color.WHITE);
		updateframe.setIconImage(Toolkit.getDefaultToolkit().getImage(AddQuestions.class.getResource("/images/write.png")));
		updateframe.setTitle("addQuestion");
		updateframe.setResizable(false);
		updateframe.getContentPane().setBackground(Color.WHITE);
		updateframe.getContentPane().setLayout(null);

		JLabel lblQuestion = new JLabel("Question :");
		lblQuestion.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblQuestion.setBounds(28, 37, 103, 28);
		updateframe.getContentPane().add(lblQuestion);

		JLabel lblAnswer = new JLabel("Answer 1 : ");
		lblAnswer.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer.setBounds(28, 93, 122, 21);
		updateframe.getContentPane().add(lblAnswer);

		JLabel lblAnswer_1 = new JLabel("Answer 2 :");
		lblAnswer_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_1.setBounds(28, 145, 103, 21);
		updateframe.getContentPane().add(lblAnswer_1);

		JLabel lblAnswer_2 = new JLabel("Answer 3 :");
		lblAnswer_2.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_2.setBounds(28, 204, 103, 21);
		updateframe.getContentPane().add(lblAnswer_2);

		JLabel lblAnswer_3 = new JLabel("Answer 4 :");
		lblAnswer_3.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblAnswer_3.setBounds(28, 256, 103, 21);
		updateframe.getContentPane().add(lblAnswer_3);

		JLabel lblCurrectAnswer = new JLabel("Currect answer :");
		lblCurrectAnswer.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblCurrectAnswer.setBounds(28, 312, 147, 21);
		updateframe.getContentPane().add(lblCurrectAnswer);

		JLabel lblLevel = new JLabel("Difficulty level :");
		lblLevel.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		lblLevel.setBounds(28, 347, 147, 21);
		updateframe.getContentPane().add(lblLevel);

		ans1 = new JTextField();
		ans1.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans1.setBounds(143, 85, 422, 36);
		updateframe.getContentPane().add(ans1);
		ans1.setColumns(10);

		ans2 = new JTextField();
		ans2.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans2.setBounds(143, 137, 422, 36);
		updateframe.getContentPane().add(ans2);
		ans2.setColumns(10);

		ans3 = new JTextField();
		ans3.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans3.setBounds(143, 196, 422, 36);
		updateframe.getContentPane().add(ans3);
		ans3.setColumns(10);

		ans4 = new JTextField();
		ans4.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		ans4.setBounds(143, 248, 422, 36);
		updateframe.getContentPane().add(ans4);
		ans4.setColumns(10);

		ButtonGroup G = new ButtonGroup();
		JRadioButton level1 = new JRadioButton("1");
		level1.setBackground(Color.WHITE);
		level1.setBounds(173, 345, 47, 25);
		updateframe.getContentPane().add(level1);

		JRadioButton level2 = new JRadioButton("2");
		level2.setBackground(Color.WHITE);
		level2.setBounds(237, 345, 47, 25);
		updateframe.getContentPane().add(level2);

		JRadioButton level3 = new JRadioButton("3");
		level3.setBackground(Color.WHITE);
		level3.setBounds(291, 345, 47, 25);
		updateframe.getContentPane().add(level3);
		updateframe.setBounds(100, 100, 735, 477);
		updateframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		G.add(level1);
		G.add(level2);
		G.add(level3);

		ButtonGroup G2 = new ButtonGroup();
		JRadioButton currect1 = new JRadioButton("1");
		currect1.setBackground(Color.WHITE);
		currect1.setBounds(173, 310, 47, 25);
		updateframe.getContentPane().add(currect1);

		JRadioButton currect2 = new JRadioButton("2");
		currect2.setBackground(Color.WHITE);
		currect2.setBounds(237, 310, 47, 25);
		updateframe.getContentPane().add(currect2);

		JRadioButton currect3 = new JRadioButton("3");
		currect3.setBackground(Color.WHITE);
		currect3.setBounds(291, 310, 47, 25);
		updateframe.getContentPane().add(currect3);

		JRadioButton currect4 = new JRadioButton("4");
		currect4.setBackground(Color.WHITE);
		currect4.setBounds(345, 310, 47, 25);
		updateframe.getContentPane().add(currect4);

		G2.add(currect1);
		G2.add(currect2);
		G2.add(currect3);
		G2.add(currect4);

		JButton btnAdd = new JButton("Update Question");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setFont(new Font("Segoe Print", Font.PLAIN, 16));


		btnAdd.setBounds(301, 382, 185, 42);
		updateframe.getContentPane().add(btnAdd);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddQuestions.class.getResource("/images/Question.jpg")));
		label.setBounds(526, 216, 203, 221);
		updateframe.getContentPane().add(label);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				QuestionsView Q = new QuestionsView();
				Q.Qframe.setVisible(true);
				updateframe.dispose();
			}
		});
		button.setIcon(new ImageIcon(AddQuestions.class.getResource("/images/back.jpg")));
		button.setBounds(35, 392, 56, 29);
		updateframe.getContentPane().add(button);

		JComboBox quesCombo = new JComboBox();
		quesCombo.setBackground(Color.WHITE);
		quesCombo.setBounds(143, 41, 422, 28);
		for(Question q : SysData.getInstance().getQuestionsssss())
			quesCombo.addItem(q.getQuestion());
		
		Question question = SysData.getInstance().getSpecificQuestion(quesCombo.getSelectedItem().toString());
		ans1.setText(question.getAnswers().get(0));
		ans2.setText(question.getAnswers().get(1));
		ans3.setText(question.getAnswers().get(2));
		ans4.setText(question.getAnswers().get(3));

		if(question.getCurrectAnsw()==1)
			currect1.setSelected(true);
		else if(question.getCurrectAnsw()==2)
			currect2.setSelected(true);
		else if(question.getCurrectAnsw()==3)
			currect3.setSelected(true);
		else
			currect4.setSelected(true);

		if(question.getClass().getSimpleName().equals("WhiteQuestion"))
			level1.setSelected(true);
		else if(question.getClass().getSimpleName().equals("YellowQuestion"))
			level2.setSelected(true);
		else
			level3.setSelected(true);

		updateframe.getContentPane().add(quesCombo);

		quesCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Question question = SysData.getInstance().getSpecificQuestion(quesCombo.getSelectedItem().toString());
				ans1.setText(question.getAnswers().get(0));
				ans2.setText(question.getAnswers().get(1));
				ans3.setText(question.getAnswers().get(2));
				ans4.setText(question.getAnswers().get(3));

				if(question.getCurrectAnsw()==1)
					currect1.setSelected(true);
				else if(question.getCurrectAnsw()==2)
					currect2.setSelected(true);
				else if(question.getCurrectAnsw()==3)
					currect3.setSelected(true);
				else
					currect4.setSelected(true);

				if(question.getClass().getSimpleName().equals("WhiteQuestion"))
					level1.setSelected(true);
				else if(question.getClass().getSimpleName().equals("YellowQuestion"))
					level2.setSelected(true);
				else
					level3.setSelected(true);
			}

		});


		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

								String question = quesCombo.getSelectedItem().toString();
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
				
								if(SysData.getInstance().updateQuestion(q)) {
									JOptionPane.showMessageDialog(null, "The question updated successfully");
									return;
								}
				
//								for(Question qqq : SysData.getInstance().getQuestionsAfterRead()) {
//									if(qqq.getQuestion().equals(q.getQuestion())) {
//										JOptionPane.showMessageDialog(null, "The question updated successfully");
//										return;
//									}
//								}
					      	 
								JOptionPane.showMessageDialog(null, "Failed to update the question");
								return;
				//               
			}
		}); 

	}
}