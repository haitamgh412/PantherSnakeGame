package View;

import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Apple;
import Model.Board;

public class FoodView {
	
	private static Image apple;
    private static Image banana;
    private static Image pear;
    private static Image mouse;
    
	public FoodView(){
		
		ImageIcon iia = new ImageIcon(Apple.class.getResource("/images/apple.png"));
	    apple = iia.getImage();
	    
        ImageIcon iib = new ImageIcon(Board.class.getResource("/images/newBanana.png"));
        banana = iib.getImage();
        
        ImageIcon iip = new ImageIcon(Board.class.getResource("/images/pear.png"));
        pear = iip.getImage();
        
        ImageIcon iimd = new ImageIcon(Board.class.getResource("/images/newMouse.png"));
        mouse = iimd.getImage();
        
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
	
	public Image Getmouse() {
		return mouse;
	}
	
}
