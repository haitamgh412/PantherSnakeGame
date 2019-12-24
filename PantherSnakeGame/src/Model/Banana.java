

package Model;

import java.awt.Image;

import javax.swing.ImageIcon;

import View.FoodView;

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
		

        
        int a = (int) (Math.random() * Board.RAND_POS);
        this.banana_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.banana_y = ((a * Board.DOT_SIZE));
        	
		FoodView foodView=new FoodView();
        this.banana=foodView.GetBanana();

	}
	
	/*
	 * return the coordinate X of the banana
	 */
	public int getX() {
		return this.banana_x;
	}
	/*
	 * return the coordinate Y of the banana
	 */
	public int getY() {
		return this.banana_y;
	}
	
	/*
	 * return the image of the banana
	 */
	public Image getImage() {
		return this.banana;
	}
	
	/*
	 * clear the banana off the Board
	 */
	public void clear() {
		
		this.banana_x=-50;
		this.banana_y=-50;
		this.banana=null;
	}
	
	/*
	 * clear the banana on the board , wait 10 seconds and generate new banana 
	 * on another random place
	 */
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
	
	/*
	 * return the the points that the banana adds
	 */
	public int addPoints() {
		return (bananaPoints);
	}
	
	
}
