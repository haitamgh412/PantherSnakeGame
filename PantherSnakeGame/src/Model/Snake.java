package Model;


import java.awt.EventQueue;

import javax.swing.JFrame;

public class Snake extends JFrame {
	
      public JFrame snakeframe;


    public Snake() {
    	
    	
        initUI();

    }
    
    private void initUI() {
    	
        add(new Board());

        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    


}