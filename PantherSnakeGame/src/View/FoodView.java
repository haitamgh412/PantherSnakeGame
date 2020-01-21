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
    private static Image strawberry;
    
    private static Image RedQuestion;
    private static Image WhiteQuestion;
    private static Image YellowQuestion;

    
	public FoodView(){
		
		ImageIcon iia = new ImageIcon(Apple.class.getResource("/images/apple.png"));
	    apple = iia.getImage();
	    
        ImageIcon iib = new ImageIcon(Board.class.getResource("/images/newBanana.png"));
        banana = iib.getImage();
        
        ImageIcon iip = new ImageIcon(Board.class.getResource("/images/pear.png"));
        pear = iip.getImage();
        
        ImageIcon iimd = new ImageIcon(Board.class.getResource("/images/newMouse.png"));
        mouse = iimd.getImage();
        
        ImageIcon iis = new ImageIcon(Apple.class.getResource("/images/strawberry.png"));
        strawberry = iis.getImage();
        
		ImageIcon iiaa = new ImageIcon(Apple.class.getResource("/images/redQ.png"));
		RedQuestion = iiaa.getImage();
        
		ImageIcon iiab = new ImageIcon(Apple.class.getResource("/images/whiteQ.png"));
		WhiteQuestion = iiab.getImage();
        
		ImageIcon iiac = new ImageIcon(Apple.class.getResource("/images/yellowQ.png"));
        YellowQuestion = iiac.getImage();
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

	public Image Getstrawberry() {
		return strawberry;
	}
	
	public static Image getRedQuestion() {
		return RedQuestion;
	}

	public static Image getWhiteQuestion() {
		return WhiteQuestion;
	}

	public static Image getYellowQuestion() {
		return YellowQuestion;
	}
	
	
	
}
