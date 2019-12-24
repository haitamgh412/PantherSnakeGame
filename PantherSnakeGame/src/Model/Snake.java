package Model;


import java.awt.Image;


import javax.swing.ImageIcon;


public class Snake {
	
    public int dots;
    private Image ball;
    public static Image head;
    
    private int snake_x;
    private int snake_y;
    
    


    public Snake() {
    	
    	//initBoard();
    	ImageIcon iid = new ImageIcon(Board.class.getResource("/images/dot.png"));
        ball = iid.getImage();
        ImageIcon iih = new ImageIcon(Board.class.getResource("/images/headR.png"));
        head = iih.getImage();
    }
    
    public void initGame() {

        dots = 1;

        for (int z = 0; z < dots; z++) {
            Board.x[z] = 310 - z * 10;
            Board.y[z] = 300;
        }
        
//
//        Board.timer = new Timer(Board.DELAY, this);
//        Board.timer.start();
        
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
	
	/*
	 * return the image of the snake head
	 */
	public Image getImage() {
		return Snake.head;
	}
	
	/*
	 * return the image of the snake ball
	 */
	public Image getImage1() {
		return this.ball;
	}


    


}