package View;


import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Controller.SysData;
import tables.ScoreTable;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class HighScores {

	public JFrame scoreframe;
	private JTable table;


	/**
	 * Create the application.
	 */
	public HighScores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		scoreframe = new JFrame();
		scoreframe.getContentPane().setBackground(Color.WHITE);
		scoreframe.setIconImage(Toolkit.getDefaultToolkit().getImage(HighScores.class.getResource("/images/icon.png")));
		scoreframe.setTitle("high Scores");
		scoreframe.setBounds(100, 100, 674, 443);
		scoreframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("");
		button.setBounds(15, 348, 62, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainScreen f = new MainScreen();
				f.framefirst.setVisible(true);
				scoreframe.dispose();	
			}
		});
		scoreframe.getContentPane().setLayout(null);
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(HighScores.class.getResource("/images/back.jpg")));
		scoreframe.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setBounds(0, -30, 326, 423);
		label.setIcon(new ImageIcon(HighScores.class.getResource("/images/score.jpg")));
		scoreframe.getContentPane().add(label);
		
		JLabel lblTop = new JLabel("Top 10");
		lblTop.setBounds(364, 16, 162, 56);
		lblTop.setHorizontalAlignment(SwingConstants.CENTER);
		lblTop.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		scoreframe.getContentPane().add(lblTop);
		
	
		ScoreTable score1 =  new ScoreTable(SysData.getInstance().getTopPlayers());
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
			    scrollPane.setBounds(305, 87, 299, 284);
			    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scoreframe.getContentPane().add(scrollPane);
			 table.getTableHeader().setFont(new Font("Segoe Print", Font.ITALIC, 24));
			 table.getTableHeader().setBackground(Color.white);
			table.setRowHeight(50);
				table.setFont(new Font("Segoe Print", Font.PLAIN, 20));
			       scrollPane.setViewportView(table);
			      
			       scoreframe.getContentPane().add(scrollPane);

	}
}
