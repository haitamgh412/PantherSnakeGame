package View;

import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Apple;
import Model.Board;

public class FoodView {
	
	private static Image apple;
    private static Image banana;
    private static Image pear;
    private static Image mouse_down;
    private static Image mouse_right;
    private static Image mouse_left;
    private static Image mouse_up;
    
	public FoodView(){
		
		ImageIcon iia = new ImageIcon(Apple.class.getResource("/images/apple.png"));
	    apple = iia.getImage();
	    
        ImageIcon iib = new ImageIcon(Board.class.getResource("/images/banana.png"));
        banana = iib.getImage();
        
        ImageIcon iip = new ImageIcon(Board.class.getResource("/images/pear.png"));
        pear = iip.getImage();
        
        ImageIcon iimd = new ImageIcon(Board.class.getResource("/images/mouse_down.png"));
        mouse_down = iimd.getImage();
        ImageIcon iimr = new ImageIcon(Board.class.getResource("/images/mouse_right.png"));
        mouse_right = iimr.getImage();
        ImageIcon iiml = new ImageIcon(Board.class.getResource("/images/mouse_left.png"));
        mouse_left = iiml.getImage();
        ImageIcon iimu = new ImageIcon(Board.class.getResource("/images/mouse_up.png"));
        mouse_up = iimu.getImage();
        
	}
	
	public Image GetApple() {
		return apple;
	}
	
	public Image GetBanana() {
		return banana;
	}
	
	public Image GetPear() {
		return pear;
	}
	
	public Image Getmouse_down() {
		return mouse_down;
	}
	
	public Image Getmouse_right() {
		return mouse_right;
	}
	
	public Image Getmouse_left() {
		return mouse_left;
	}
	
	public Image Getmouse_up() {
		return mouse_up;
	}
	
}
