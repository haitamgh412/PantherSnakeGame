package Model;

import java.awt.Image;

import View.FoodView;

public class Strawberry implements Fruit {

    private int strawberry_x;
    private int strawberry_y;
    private Image strawberry;
    
	/** Creates a new instance of strawberry */
	public Strawberry() {

		generateFood();

	}
	
	/*
	 * Create an new Apple in the the random coordinates x and y
	 */
	public void generateFood() {
		 
        int a = (int) (Math.random() * Board.RAND_POS);
        this.strawberry_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.strawberry_y = ((a * Board.DOT_SIZE));
        
		FoodView foodView=new FoodView();
        this.strawberry=foodView.Getstrawberry();
             
	}
	
	/*
	 * return the coordinate X of the apple
	 */
	public int getX() {
		return this.strawberry_x;
	}
	
	/*
	 * return the coordinate Y of the apple
	 */
	public int getY() {
		return this.strawberry_y;
	}
	
	/*
	 * return the image of the apple
	 */
	public Image getImage() {
		return this.strawberry;
	}
	
	/*
	 * clear the banana off the Board
	 */
	public void clear() {
		
		this.strawberry_x=-50;
		this.strawberry_y=-50;
		this.strawberry=null;
	}
	
	/*
	 * clear the apple on the board , wait 5 seconds and generate new apple 
	 * on another random place
	 */
	public void random() {
		clear();
        generateFood();
       
	}

	
}
