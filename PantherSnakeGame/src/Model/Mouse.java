

package Model;

import java.awt.Image;


import javax.swing.ImageIcon;

import View.Instructions;

public class Mouse {

    private int mouse_x;
    private int mouse_y;
    
    private Image mouse_down;
    private Image mouse_right;
    private Image mouse_left;
    private Image mouse_up;
    
    private final int mousePoints = 30;
    
	/** Creates a new instance of Mouse */
	public Mouse() {

		generateFood();
	}
	
	/*
	 * Create an new Apple in the the random coordinates x and y
	 */
	public void generateFood() {
		
		
        ImageIcon iimd = new ImageIcon(Board.class.getResource("/images/mouse_down.png"));
        mouse_down = iimd.getImage();
        ImageIcon iimr = new ImageIcon(Board.class.getResource("/images/mouse_right.png"));
        mouse_right = iimr.getImage();
        ImageIcon iiml = new ImageIcon(Board.class.getResource("/images/mouse_left.png"));
        mouse_left = iiml.getImage();
        ImageIcon iimu = new ImageIcon(Board.class.getResource("/images/mouse_up.png"));
        mouse_up = iimu.getImage();
        
        int a = (int) (Math.random() * Board.RAND_POS);
        this.mouse_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.mouse_y = ((a * Board.DOT_SIZE));
        

	}
	
	public int getX() {
		return this.mouse_x;
	}
	public int getY() {
		return this.mouse_y;
	}
	public Image getImage(int direction) {
		
		if (direction==1)return this.mouse_up;
		if (direction==2)return this.mouse_down;
		if (direction==3)return this.mouse_right;
		if (direction==4)return this.mouse_left;
		return mouse_up;
		
	}
	
	public void random() {
        int a = (int) (Math.random() * Board.RAND_POS);
        this.mouse_x = ((a * Board.DOT_SIZE));

        a = (int) (Math.random() * Board.RAND_POS);
        this.mouse_y = ((a * Board.DOT_SIZE));
        
	}
	
	public int addPoints() {
		return (mousePoints);
	}
	
	
}
