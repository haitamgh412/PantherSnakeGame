package Model;


import java.awt.Image;


import javax.swing.ImageIcon;


public class Snake {
	
    private int dots;
    private Image ball;
    public static Image head;
    private Image resumeHead;
    
    private int snake_x;
    private int snake_y;
    
    
    public Snake() {
    	
    	ImageIcon iid = new ImageIcon(Board.class.getResource("/images/dot.png"));
        ball = iid.getImage();
        ImageIcon iih = new ImageIcon(Board.class.getResource("/images/headR1.png"));
        head = iih.getImage();
        resumeHead=iih.getImage();
    }
    
    /**
     * In the initGame() method we create the snake,
     *  randomly locate the fruits mouse and questions on the board, and start the timer.
     */


    public void initGame() {

        dots = 1;

        for (int z = 0; z < dots; z++) {
            Board.x[z] = 310 - z * 10;
            Board.y[z] = 300;
        }
    }

	/*
	 * return the coordinate X of the snake
	 */
	public int getX() {
		return this.snake_x;
	}
	
	/*
	 * return the coordinate Y of the snake
	 */
	public int getY() {
		return this.snake_y;
	}
	
	
	public int getDots() {
		return dots;
	}

	public void setDots(int dots) {
		this.dots = dots;
	}

	/*
	 * return the image of the snake head
	 */
	public Image getImage() {
		return Snake.head;
	}
	
	public void setImage(Image hx) {
		Snake.head=hx;
	}
	
	/*
	 * return the image of the snake ball (part of body)
	 */
	public Image getImage1() {
		return this.ball;
	}
	
	public Image resumeGame() {
		return resumeHead;
	}

}