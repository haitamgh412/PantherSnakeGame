package Model;


import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Snake extends JFrame {
	
      public JFrame snakeframe;


    public Snake() {
    	
    	
        initUI();

    }
    
    private void initUI() {
    	
        Board board = new Board();
        getContentPane().add(board);
        board.setLayout(null);

        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    


}