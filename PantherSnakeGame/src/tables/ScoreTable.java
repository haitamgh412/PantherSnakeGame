package tables;

import java.util.List;


import javax.swing.table.AbstractTableModel;

import Model.Player;


@SuppressWarnings("serial")
public class ScoreTable  extends AbstractTableModel {
	

	protected final List<Player> scoresTable;
	  
    private final String[] columnNames = new String[] { "UserName", "Score"};
    @SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] {
        String.class, Integer.class
    };
 
    
    public ScoreTable(List<Player> scoresTable)
    {
        this.scoresTable = scoresTable;
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return scoresTable.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
    
        Player row = scoresTable.get(rowIndex);
        if(0 == columnIndex) {
            return row.getUserName();
        }
        else if(1 == columnIndex) {
            return row.getHighScore();
        }
      
        return null;
    }
	
}
