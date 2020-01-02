package Model;

import java.awt.Image;

import View.FoodView;

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
		 
        int a = (int) (Math.random() * Board.RAND_POS);
        this.apple_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.apple_y = ((a * Board.DOT_SIZE));
        
		FoodView foodView=new FoodView();
        this.apple=foodView.GetApple();
             
	}
	
	/*
	 * return the coordinate X of the apple
	 */
	public int getX() {
		return this.apple_x;
	}
	
	/*
	 * return the coordinate Y of the apple
	 */
	public int getY() {
		return this.apple_y;
	}
	
	/*
	 * return the image of the apple
	 */
	public Image getImage() {
		return this.apple;
	}
	
	/*
	 * clear the banana off the Board
	 */
	public void clear() {
		
		this.apple_x=-50;
		this.apple_y=-50;
		this.apple=null;
	}
	
	/*
	 * clear the apple on the board , wait 5 seconds and generate new apple 
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
        5000 
		);
       
	}
	
	/*
	 * return the the points that the apple adds
	 */
	public int addPoints() {
		return (applePoints);
	}
	
}
