package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.InputManager;
import Controller.SoundManger;
import View.SnakeView;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	
	/**
	 * The B_WIDTH and B_HEIGHT constants determine the size of the board.
	 * The DOT_SIZE is the size of the dot of the snake.
	 * The ALL_DOTS constant defines the maximum number of possible dots on the board (3600 = (600*600)/(10*10)).
	 * The RAND_POS constant is used to calculate a random position for an apple 60 .
	 * The DELAY constant determines the speed of the game.
	 */

    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    public static final int DOT_SIZE = 10;
    private final static int ALL_DOTS = 3600;
    public static final int RAND_POS = 59;
    public final static int DELAY = 120;
    
	/** Creates a new instance of Board */
    
	public static boolean isGameOver = false;

	public static int timer1 = 0;
	private Timer timerT ;
	
	public static int playerScore = 0;
	public static int numOFLifes = 3;
	
	public static int mousecounter=1;
	
	private static String soundFilePath = "sound.wav";
	public static SoundManger soundManger = new SoundManger(soundFilePath);

    
    /**
     * These two arrays store the x and y coordinates of all joints of a snake.
     */

    public final static int x[] = new int[ALL_DOTS];
    public final static int y[] = new int[ALL_DOTS];
    
    private Snake snake = new Snake();
    private Apple apple = new Apple();
    private Banana banana = new Banana();
    private Pear pear = new Pear();
    private Mouse mouse = new Mouse();
    private WhiteQuestion whiteQuestion=new WhiteQuestion();
    private YellowQuestion yellowQuestion=new YellowQuestion();
    private RedQuestion redQuestion=new RedQuestion();
    


    public static boolean leftDirection = false;
    public static boolean rightDirection = true;
    public static boolean upDirection = false;
    public static boolean downDirection = false;
    public static boolean inGame = true;

    public static Timer timer;
    
    public Board() {
        
        initBoard();

    }
  
    
    private void initBoard() {
    	

        addKeyListener(new InputManager());
        setFocusable(true);
        
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        snake.initGame();

        timer = new Timer(DELAY, this);
        timer.stop();
        

         leftDirection = false;
         rightDirection = true;
         upDirection = false;
         downDirection = false;
         inGame = true;
         
         numOFLifes=3;
         playerScore=0;
         soundManger = new SoundManger(soundFilePath);
         
    }
    
    /*
     * the resumeGame used when the snake died and the game hasn't over 
     * and the player resume the game with one less life and the same score .
     * the snake return to the center of the screen with 0 length of body
     */
    public void resumeGame() {
        setFocusable(true);

     //   setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        snake.initGame();
        timer.stop();
        leftDirection = false;
        rightDirection = true;
        upDirection = false;
        downDirection = false;
        inGame = true;
        snake.setImage(snake.resumeGame());
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple.getImage(), apple.getX(), apple.getY(), this);
            g.drawImage(banana.getImage(), banana.getX(), banana.getY(), this);
            g.drawImage(pear.getImage(), pear.getX(), pear.getY(), this);
            
            
            g.drawImage(whiteQuestion.getImage(), whiteQuestion.getX(), whiteQuestion.getY(), this);
            g.drawImage(yellowQuestion.getImage(), yellowQuestion.getX(), yellowQuestion.getY(), this);
            g.drawImage(redQuestion.getImage(), redQuestion.getX(), redQuestion.getY(), this);
            
            
            g.drawImage(mouse.getImage(1), mouse.getX(), mouse.getY(), this);
//            g.drawImage(mouse.getImage(2), mouse.getX(), mouse.getY(), this);
//            g.drawImage(mouse.getImage(3), mouse.getX(), mouse.getY(), this);
//            g.drawImage(mouse.getImage(4), mouse.getX(), mouse.getY(), this);

            
            for (int z = 0; z < snake.getDots(); z++) {
                if (z == 0) {
                    g.drawImage(snake.getImage(), x[z], y[z], this);
                } else {
                    g.drawImage(snake.getImage1(), x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else if(isGameOver) {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 28);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.RED);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        
    //    Player player=new Player(SnakeView.getNewName());
    }
    
    
    private void movemouse() {
    	
    	mousecounter++;
    	if(mousecounter%6==0) {
    		mouse.changeSide();
    	}
    	
    	int side=mouse.getCurrentSide();
    	
        if (side==0&&checkMouseCollision()) {
            mouse.setY(mouse.getY()+DOT_SIZE);
        }
        else if (side==1&&checkMouseCollision()) {
            mouse.setY(mouse.getY()-DOT_SIZE);
        }
        else if (side==2&&checkMouseCollision()) {
            mouse.setX(mouse.getX()+DOT_SIZE);
        }
        else if (side==3&&checkMouseCollision()) {
            mouse.setX(mouse.getX()-DOT_SIZE);
        }
        else {
        	if(side==0) {
        		mouse.setY(mouse.getY()-DOT_SIZE);
        		mouse.setCurrentSide(1);
        	}
        	else if(side==1) {
        		mouse.setY(mouse.getY()+DOT_SIZE);
        		mouse.setCurrentSide(0);
        	}
        	else if(side==2) {
        		mouse.setX(mouse.getX()-DOT_SIZE);
        		mouse.setCurrentSide(3);
        	}
        	else if(side==3) {
        		mouse.setX(mouse.getX()+DOT_SIZE);
        		mouse.setCurrentSide(2);
        	}
        	}
        	//checkMouseCollision();
        }
        
    
    
    /*
     * TODO need to edit
     */
    
    private boolean checkMouseCollision() {
    	
        if ((mouse.getX() == apple.getX()) && (mouse.getY() == apple.getY())) {
        	mouse.changeSide();
        	return false;
        }
        if ((mouse.getX() == banana.getX()) && (mouse.getY() == banana.getY())) {
        	mouse.changeSide();
        	return false;
        }
        if ((mouse.getX() == pear.getX()) && (mouse.getY() == pear.getY())) {
        	mouse.changeSide();
        	return false;
        }
        if ((mouse.getX() == whiteQuestion.getX()) && (mouse.getY() == whiteQuestion.getY())) {
        	mouse.changeSide();
        	return false;
        }
        if ((mouse.getX() == redQuestion.getX()) && (mouse.getY() == redQuestion.getY())) {
        	mouse.changeSide();
        	return false;
        }
        if ((mouse.getX() == yellowQuestion.getX()) && (mouse.getY() == yellowQuestion.getY())) {
        	mouse.changeSide();
        	return false;
        }
        
        for (int z = snake.getDots(); z > 0; z--) {

            if ((z > 1) && (mouse.getX() == x[z]) && (mouse.getY() == y[z])) {
            	mouse.changeSide();
            	return false;
            }
        }

        if (mouse.getY() >= B_HEIGHT-DOT_SIZE) {
        	mouse.changeSide();
        	return false;
        }

        if (mouse.getY() <= 0+DOT_SIZE) {
        	mouse.changeSide();
        	return false;
        }

        if (mouse.getX() >= B_WIDTH-DOT_SIZE) {
        	mouse.changeSide();
        	return false;
        }

        if (mouse.getX() <= 0+DOT_SIZE) {
        	mouse.changeSide();
        	return false;
        }
        return true;
        	
    }
    


    /**
     * If the apple collides with the head,
       we increase the number of joints of the snake.
        We call the Random() method in the apple which randomly positions a new apple object.
     */
    private void checkApple() {

        if ((x[0] == apple.getX()) && (y[0] == apple.getY())) {

            snake.setDots(snake.getDots()+1);
            playerScore+=apple.addPoints();
            SnakeView.updatescore();
            apple.random();
        }
    }
    private void checkBanana() {

        if ((x[0] == banana.getX()) && (y[0] == banana.getY())) {

        	snake.setDots(snake.getDots()+1);
            playerScore+=banana.addPoints();
            SnakeView.updatescore();
            banana.random();
        }
    }
    private void checkPear() {

        if ((x[0] == pear.getX()) && (y[0] == pear.getY())) {

        	snake.setDots(snake.getDots()+1);
            playerScore+=pear.addPoints();
            SnakeView.updatescore();
            pear.random();
        }
    }
    
     
    private void checkWQ() {

        if ((x[0] == whiteQuestion.getX()) && (y[0] == whiteQuestion.getY())) {

      //  	playerScore+=whiteQuestion.getAnswerPoints();
            SnakeView.updatescore();
            whiteQuestion.random();
        }
    }
    private void checkRQ() {

        if ((x[0] == redQuestion.getX()) && (y[0] == redQuestion.getY())) {

    //    	playerScore+=redQuestion.getAnswerPoints();
            SnakeView.updatescore();
            redQuestion.random();
        }
    }
    private void checkYQ() {

        if ((x[0] == yellowQuestion.getX()) && (y[0] == yellowQuestion.getY())) {

   //     	playerScore+=redQuestion.getAnswerPoints();
            SnakeView.updatescore();
            yellowQuestion.random();
        }
    }
    
    private void checkM() {

        if ((x[0] == mouse.getX()) && (y[0] == mouse.getY())) {
        	
        	playerScore+=mouse.addPoints();
            SnakeView.updatescore();
            if(numOFLifes<3) {
            numOFLifes+=mouse.addLives();
            SnakeView.updateLives();
            }
            snake.setDots(snake.getDots()+2);
            mouse.random();
        }
    }


    /**
     * In the move() method we have the key algorithm of the game.
     *  To understand it, look at how the snake is moving.
     *   We control the head of the snake.
     *    We can change its direction with the cursor keys.
     *    The rest of the joints move one position up the chain.
     *     The second joint moves where the first was, the third joint where the second was etc.
     * 
     */
    private void move() {

        for (int z = snake.getDots(); z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }
        /**
         * This code moves the joints up the chain.
         */

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }
    
    /**
     * In the checkCollision() method, 
     * we determine if the snake has hit itself or one of the walls.
     * If the snake hits one of its joints with its head the game is over.
     */

    private void checkCollision() {

        for (int z = snake.getDots(); z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z]) && numOFLifes >0) {
            	numOFLifes--;
            	SnakeView.updateLives();
            	SnakeView.updateTime();
            	resumeGame();
            }
        }

        if (y[0] >= B_HEIGHT && numOFLifes >0) {
            numOFLifes--;
            SnakeView.updateLives();
            resumeGame();
        }

        if (y[0] < 0 && numOFLifes >0) {
        	numOFLifes--;
        	SnakeView.updateLives();
        	resumeGame();
        }

        if (x[0] >= B_WIDTH && numOFLifes >0) {
        	numOFLifes--;
        	SnakeView.updateLives();
        	resumeGame();
        }

        if (x[0] < 0 && numOFLifes >0) {
        	numOFLifes--;
        	SnakeView.updateLives();
        	resumeGame();
        }
        
        if(numOFLifes == 0) { 
        	inGame=false;
        	timer.stop();
            setGameOver(true);
        	}
        
        if (!inGame) {
            timer.stop();
            soundManger.stopSound();
            if(numOFLifes==0) setGameOver(true);
        }
    }
    
    public static void pause() {
    	
    	if(timer.isRunning()) {
    		timer.stop();
    		soundManger.pauseSound();
    		}
    	else {
    		timer.start();
    	    soundManger.startSound();
    	}
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
        	
        	checkM();
            checkApple();
            checkBanana();
            checkPear();
            
            checkRQ();
            checkWQ();
            checkYQ();
            
            
            
            checkCollision();
            move();
            checkMouseCollision();
            movemouse();

            
        }
        
        repaint();
    }

	public int getPlayerScore() {
		return playerScore;
	}

	public int getNumOFLifes() {
		return numOFLifes;
	}
	
	public int getTime() {
		
    	timerT = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isGameOver) {
					timer.stop();
					timerT.stop();
					soundManger.stopSound();
				}
				timer1++;
			}
		});
		return timer1;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public static void setGameOver(boolean isGameOver) {
		Board.isGameOver = isGameOver;
	}
	
}