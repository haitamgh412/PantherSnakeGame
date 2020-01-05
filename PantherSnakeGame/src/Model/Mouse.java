package Model;

import java.awt.Image;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import View.FoodView;

public class Mouse {

    private int mouse_x;
    private int mouse_y;
    
    private Image mouse_down;
    private Image mouse_right;
    private Image mouse_left;
    private Image mouse_up;
    
    private final int mousePoints = 30;
    private final int mouseLives = 1;
    
    private int currentside;
	/** Creates a new instance of Mouse */
	public Mouse() {

		generateFood();
	}
	
	/*
	 * Create an new Apple in the the random coordinates x and y
	 */
	public void generateFood() {
		      
        int a = (int) (Math.random() * Board.RAND_POS);
        this.mouse_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.mouse_y = ((a * Board.DOT_SIZE));
        

		FoodView foodView=new FoodView();
        this.mouse_down=foodView.Getmouse_down();
        this.mouse_right=foodView.Getmouse_right();
        this.mouse_left=foodView.Getmouse_left();
        this.mouse_up=foodView.Getmouse_up();

	}
	
	public int getX() {
		return this.mouse_x;
	}
	public int getY() {
		return this.mouse_y;
	}
	
	
	
	public void setX(int mouse_x) {
		this.mouse_x = mouse_x;
	}

	public void setY(int mouse_y) {
		this.mouse_y = mouse_y;
	}

	public void setMouse_down(Image mouse_down) {
		this.mouse_down = mouse_down;
	}

	public void setMouse_right(Image mouse_right) {
		this.mouse_right = mouse_right;
	}

	public void setMouse_left(Image mouse_left) {
		this.mouse_left = mouse_left;
	}

	public void setMouse_up(Image mouse_up) {
		this.mouse_up = mouse_up;
	}

	public Image getImage(int direction) {
		
		if (direction==0)return this.mouse_up;
		if (direction==1)return this.mouse_down;
		if (direction==2)return this.mouse_right;
		if (direction==3)return this.mouse_left;
		return mouse_up;
		
	}
	
	public void clear() {
		mouse_x=-5000;
		mouse_y=-5000;
	}
	
	
	public int addPoints() {
		return (mousePoints);
	}
	
	public int addLives() {
		return (mouseLives);
	}
	
	/*
	 * clear the mouse on the board , wait 1 minute and generate new mouse 
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
        60000 
        );
	}
	
	public void changeSide() {
			 this.currentside=generateRandomside();	
	}
		
	public int getCurrentSide() {
	//	changeSide();
		return this.currentside;	
	}
	
	public void setCurrentSide(int x) {
		this.currentside=x;
	}
	
	private int generateRandomside() {
        int a = (int) (Math.random() * 4);
        return a;
        
	}
	
}