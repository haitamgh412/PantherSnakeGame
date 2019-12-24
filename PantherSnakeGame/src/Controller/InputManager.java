package Controller;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import Model.Board;
import Model.Snake;

public class InputManager implements KeyListener{
	
	
	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();

	            if ((key == KeyEvent.VK_LEFT) && (!Board.rightDirection)) {
	            	Board.leftDirection = true;
	            	Board. upDirection = false;
	            	Board. downDirection = false;
	                ImageIcon iih = new ImageIcon(Board.class.getResource("/images/headL.png"));
	                Snake.head = iih.getImage();
	               
	            }

	            if ((key == KeyEvent.VK_RIGHT) && (!Board.leftDirection)) {
	            	Board.rightDirection = true;
	            	Board.upDirection = false;
	            	Board.downDirection = false;
	                ImageIcon iih = new ImageIcon(Board.class.getResource("/images/headR.png"));
	                Snake.head  = iih.getImage();
	            }

	            if ((key == KeyEvent.VK_UP) && (!Board.downDirection)) {
	            	Board.upDirection = true;
	            	Board.rightDirection = false;
	            	Board.leftDirection = false;
	                ImageIcon iih = new ImageIcon(Board.class.getResource("/images/headU.png"));
	                Snake.head = iih.getImage();
	            }

	            if ((key == KeyEvent.VK_DOWN) && (!Board.upDirection)) {
	            	Board.downDirection = true;
	            	Board.rightDirection = false;
	            	Board.leftDirection = false;
	                ImageIcon iih = new ImageIcon(Board.class.getResource("/images/headD.png"));
	                Snake.head  = iih.getImage();
	            }
	             if (key == KeyEvent.VK_SPACE) {

//	    			if (Board.isGameRunning()) {
//	    				Board.pauseGame();
//
//	    			} else {
//	    				Board.initGame();
	            	 Board.pause();
	            	 
	    			}

	    		 if (key == KeyEvent.VK_ESCAPE) {

	    			System.exit(0);
	    		}
	        
	        }
	        

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

}
