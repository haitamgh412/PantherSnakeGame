

package Model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Pear {

    private int pear_x;
    private int pear_y;
    private Image pear;
    private final int pearPoints =20;
    
	/** Creates a new instance of Apple */
	public Pear() {

		generateFood();
	}
	
	/*
	 * Create an new Apple in the the random coordinates x and y
	 */
	public void generateFood() {
		
        ImageIcon iip = new ImageIcon("src/images/pear.png");
        pear = iip.getImage();
        
        int a = (int) (Math.random() * Board.RAND_POS);
        this.pear_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.pear_y = ((a * Board.DOT_SIZE));
        	

	}
	
	public int getX() {
		return this.pear_x;
	}
	public int getY() {
		return this.pear_y;
	}
	public Image getImage() {
		return this.pear;
	}
	
	public void random() {
        int a = (int) (Math.random() * Board.RAND_POS);
        this.pear_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.pear_y = ((a * Board.DOT_SIZE));
        
	}
	
	public int addPoints() {
		return (pearPoints);
	}
	
	
}
