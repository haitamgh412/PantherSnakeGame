

package Model;

import java.awt.Image;


import javax.swing.ImageIcon;

import View.Instructions;

public class Apple implements Fruit {

    private int apple_x;
    private int apple_y;
    private Image apple;
    private final int applePoints = 10;
    
	/** Creates a new instance of Apple */
	public Apple() {

		generateFood();
	}
	
	/*
	 * Create an new Apple in the the random coordinates x and y
	 */
	public void generateFood() {
		
		
		ImageIcon iia = new ImageIcon(Apple.class.getResource("/images/apple.png"));
        apple = iia.getImage();
        
        int a = (int) (Math.random() * Board.RAND_POS);
        this.apple_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.apple_y = ((a * Board.DOT_SIZE));
        
        
		
		

	}
	
	public int getX() {
		return this.apple_x;
	}
	public int getY() {
		return this.apple_y;
	}
	public Image getImage() {
		return this.apple;
	}
	
	public void random() {
        int a = (int) (Math.random() * Board.RAND_POS);
        this.apple_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.apple_y = ((a * Board.DOT_SIZE));
        
	}
	
	public int addPoints() {
		return (applePoints);
	}
	
	
}
