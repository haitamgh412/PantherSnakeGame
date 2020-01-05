package View;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Controller.SysData;
import tables.QuestionTable;
import tables.ScoreTable;

import java.awt.Font;

public class QuestionsView {

	public JFrame Qframe;
	private JTable table;
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
		Qframe.getContentPane().setBackground(Color.WHITE);
		Qframe.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		Qframe.setTitle("Question");
		Qframe.setIconImage(Toolkit.getDefaultToolkit().getImage(QuestionsView.class.getResource("/images/write.png")));
		Qframe.setBounds(100, 100, 856, 536);
		Qframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Qframe.getContentPane().setLayout(null);
		
		JButton btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddQuestions f = new AddQuestions();
				f.Addframe.setVisible(true);
				Qframe.dispose();
			}
		});
		btnAddQuestion.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnAddQuestion.setBackground(Color.WHITE);
		btnAddQuestion.setBounds(235, 414, 192, 50);
		Qframe.getContentPane().add(btnAddQuestion);
		
		JButton btnRemovQuestion = new JButton("Remove Question");
		btnRemovQuestion.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnRemovQuestion.setBackground(Color.WHITE);
		btnRemovQuestion.setBounds(99, 348, 192, 50);
		Qframe.getContentPane().add(btnRemovQuestion);
		
		JButton btnUpdateQuestion = new JButton("Update Question");
		btnUpdateQuestion.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		btnUpdateQuestion.setBackground(Color.WHITE);
		btnUpdateQuestion.setBounds(402, 348, 192, 50);
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
		button.setBounds(15, 435, 60, 29);
		Qframe.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(QuestionsView.class.getResource("/images/Question.jpg")));
		label.setBounds(636, 225, 452, 278);
		Qframe.getContentPane().add(label);
		
		
		QuestionTable score1 =  new QuestionTable(SysData.getInstance().getQuestionsssss());
		score1.fireTableDataChanged();

		  
		  table= new JTable(score1)
		  {
			    @Override
			       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			           Component component = super.prepareRenderer(renderer, row, column);
			           int rendererWidth = component.getPreferredSize().width;
			           TableColumn tableColumn = getColumnModel().getColumn(column);
			           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
			           return component;
			        }
			    };
			    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			    JScrollPane scrollPane = new JScrollPane(table);
			    scrollPane.setBounds(15, 16, 626, 278);
			    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			    Qframe.getContentPane().add(scrollPane);
			 table.getTableHeader().setFont(new Font("Segoe Print", Font.ITALIC, 18));
			 table.getTableHeader().setBackground(Color.white);
			table.setRowHeight(50);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setWidth(150);
				table.setFont(new Font("Segoe Print", Font.PLAIN, 10));
			       scrollPane.setViewportView(table);
			      
			       Qframe.getContentPane().add(scrollPane);
	}
}
