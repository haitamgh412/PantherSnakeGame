

package Model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Banana implements Fruit{

    private int banana_x;
    private int banana_y;
    private Image banana;
    private final int bananaPoints = 15;
    
	/** Creates a new instance of Apple */
	public Banana() {

		generateFood();
	}
	
	/*
	 * Create an new Apple in the the random coordinates x and y
	 */
	public void generateFood() {
		
        ImageIcon iib = new ImageIcon(Board.class.getResource("/images/banana.png"));
        banana = iib.getImage();
        
        int a = (int) (Math.random() * Board.RAND_POS);
        this.banana_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.banana_y = ((a * Board.DOT_SIZE));
        	

	}
	
	public int getX() {
		return this.banana_x;
	}
	public int getY() {
		return this.banana_y;
	}
	public Image getImage() {
		return this.banana;
	}
	
	public void clear() {
		
		this.banana_x=-50;
		this.banana_y=-50;
		this.banana=null;
	}
	
	public void random() {
		
		clear();
		new java.util.Timer().schedule( 
        new java.util.TimerTask() {
			@Override
            public void run() {
                generateFood();
            }
        }, 
        10000 
        );
	}
	
	public int addPoints() {
		return (bananaPoints);
	}
	
	
}
