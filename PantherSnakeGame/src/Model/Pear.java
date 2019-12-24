package Model;

import java.awt.Image;
import java.util.Random;

import View.FoodView;

public class Pear implements Fruit{

    private int pear_x;
    private int pear_y;
    private Image pear;
    private int numofcorner;
    private final int pearPoints =20;
    
	/** Creates a new instance of Apple */
	public Pear() {

		generateFood();
	}
	
	/*
	 * Create an new Apple in a random corner
	 */
	public void generateFood() {
		

		FoodView foodView=new FoodView();
        this.pear=foodView.GetPear();
        
        Random rand = new Random();
        numofcorner = rand.nextInt(4);
        corner(numofcorner);
        	
	}
	/*
	 * return the coordinate x of the pear
	 */
	public int getX() {
		return this.pear_x;
	}
	/*
	 * return the coordinate Y of the pear
	 */
	public int getY() {
		return this.pear_y;
	}
	/*
	 * return the image of the pear
	 */
	public Image getImage() {
		return this.pear;
	}
	
	/*
	 * clear the pear off the Board
	 */
	public void clear() {
		
		this.pear_x=-50;
		this.pear_y=-50;
		this.pear=null;
	}
	
	/*
	 * Generate a random corner from the the 3 corners (not the one that the pear is on it)
	 * and puts the pear on it 
	 */
	
	public void random() {
		
		Random rand = new Random();
		int z= rand.nextInt(4);
		while(z==numofcorner) {
			z=rand.nextInt(4);
		}
        numofcorner=z;
        corner(numofcorner);
	}
	
	/*
	 * return the the points that the pear adds
	 */
	public int addPoints() {
		return (pearPoints);
	}
	
	/*
	 *  puts the pear in the selected corner 
	 */
	private void corner(int cx) {
		
		if (cx==0) {
			pear_x=0;
			pear_y=0;
		}
		if (cx==1) {
			pear_x=Board.RAND_POS*Board.DOT_SIZE;
			pear_y=0;
		}
		if (cx==2) {
			pear_x=0;
			pear_y=Board.RAND_POS*Board.DOT_SIZE;
		}
		if (cx==3) {
			pear_x=Board.RAND_POS*Board.DOT_SIZE;
			pear_y=Board.RAND_POS*Board.DOT_SIZE;
		}
		
	}
	
	
}
