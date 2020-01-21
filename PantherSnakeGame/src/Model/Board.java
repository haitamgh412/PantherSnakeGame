package Model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.InputManager;
import Controller.SoundManger;
import View.Setting;
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

    public static final int B_WIDTH = 600;
    public static final int B_HEIGHT = 600;
    public static final int DOT_SIZE = 10;
    private final static int ALL_DOTS = 3600;
    public static final int RAND_POS = 59;
    public final static int DELAY = 100;
    
	/** Creates a new instance of Board */
    
	public static boolean isGameOver = false;
	
	public static int playerScore = 0;
	public static int numOFLifes = 3;
	
	/*
	 * count for the mouse to change direction
	 */
	public static int mouseStepsCounter=0;
	
	
	/*
	 * the sounds files
	 */
	private static String soundFilePath = "sound.wav";
	private static String soundFilePath1 = "eatSound.wav";
	private static String soundFilePath2 = "mouseEat.wav";
	private static String soundFilePath3 = "gameOver.wav";

	public static SoundManger soundManger = new SoundManger(soundFilePath);
	public static SoundManger soundManger1 = new SoundManger(soundFilePath1);
	public static SoundManger soundManger2 = new SoundManger(soundFilePath2);
	public static SoundManger soundManger3 = new SoundManger(soundFilePath3);

    
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
    private Strawberry strawberry = new Strawberry();
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
  
    /*
     * the game start while the snake in the center of the board
     * the default direction is right
     * the snake is paused till the user press space 
     * num of lives equal to 3 
     * the score is 0
     */
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
         soundManger1 = new SoundManger(soundFilePath1);
         soundManger2 = new SoundManger(soundFilePath2);
         soundManger3 = new SoundManger(soundFilePath3);
         
         /*
          * if in the setting the music is off then the board start without sound
          */
         if(Setting.sound == false) {
        	 soundManger.pauseSound();
         }      
    }
    
    /*
     * the resumeGame used when the snake died and the game hasn't over 
     * and the player resume the game with one less life and the same score .
     * the snake return to the center of the screen with 0 length of body
     * if in the setting the music is off then resumes the game without sound
     */
    public void resumeGame() {
        setFocusable(true);

        if(Setting.sound == false) {
       	 soundManger.pauseSound();
        }
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
    
    /*
     * this method draw all the images on the board
     */
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple.getImage(), apple.getX(), apple.getY(), this);
            g.drawImage(banana.getImage(), banana.getX(), banana.getY(), this);
            g.drawImage(pear.getImage(), pear.getX(), pear.getY(), this);
            
            g.drawImage(strawberry.getImage(), strawberry.getX(), strawberry.getY(), this);

                
            g.drawImage(whiteQuestion.getImage(), whiteQuestion.getX(), whiteQuestion.getY(), this);
            g.drawImage(yellowQuestion.getImage(), yellowQuestion.getX(), yellowQuestion.getY(), this);
            g.drawImage(redQuestion.getImage(), redQuestion.getX(), redQuestion.getY(), this);
                       
            g.drawImage(mouse.getMouse(), mouse.getX(), mouse.getY(), this);
            
            for (int z = 0; z < snake.getDots(); z++) {
                if (z == 0) {
                    g.drawImage(snake.getImage(), x[z], y[z], this);
                } else {
                    g.drawImage(snake.getImage1(), x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
            /*
             * if the user finished the 3 lives then it draws Game over page and start the voice 
             * of game over
             */
        } else if(isGameOver) {

           SnakeView.gameOver(g);
           
           soundManger3.startSound();
           
           /*
            * the timer is to stop the sound , without timer the sound will repeat 
            */
   		new java.util.Timer().schedule( 
   		        new java.util.TimerTask() {
   					@Override
   		            public void run() {
                          soundManger3.pauseSound();
   		            }
   		        }, 
   		        7000 
   				);
        }        
    }
    
    /*
     * move mouse is the method control the movement of the mouse 
     */
    private void movemouse() {
    	
    	//the mouse change direction every 6 steps if he is not on the border
    	
    	if(mouseStepsCounter%6==0&&!checkMouseCollision()) {
    		mouse.changeSide();
    		mouseStepsCounter=0;
    	}
    	mouseStepsCounter++;
    	
    	// if the the mouse is not on collision with any object or border the mouse moves 
    	
    	int side=mouse.getCurrentSide();
    	
        if (side==0&&!checkMouseCollision()) {
            mouse.setY(mouse.getY()+DOT_SIZE);
        }
        else if (side==1&&!checkMouseCollision()) {
            mouse.setY(mouse.getY()-DOT_SIZE);
        }
        else if (side==2&&!checkMouseCollision()) {
            mouse.setX(mouse.getX()+DOT_SIZE);
        }
        else if (side==3&&!checkMouseCollision()) {
            mouse.setX(mouse.getX()-DOT_SIZE);
        }
        else {
        	//if there is collision with any object the mouse get go back to the opposite side 
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
        }
        
    
    
    /*
     * the method check if there is collision between the mouse and any another object ( fruit snake body or border) 
     */
    
    private boolean checkMouseCollision() {
    	
        if ((mouse.getX() == apple.getX()) && (mouse.getY() == apple.getY())) {
        	mouse.changeSide();
        	return true;
        }
        if ((mouse.getX() == banana.getX()) && (mouse.getY() == banana.getY())) {
        	mouse.changeSide();
        	return true;
        }
        if ((mouse.getX() == pear.getX()) && (mouse.getY() == pear.getY())) {
        	mouse.changeSide();
        	return true;
        }
        if ((mouse.getX() == whiteQuestion.getX()) && (mouse.getY() == whiteQuestion.getY())) {
        	mouse.changeSide();
        	return true;
        }
        if ((mouse.getX() == redQuestion.getX()) && (mouse.getY() == redQuestion.getY())) {
        	mouse.changeSide();
        	return true;
        }
        if ((mouse.getX() == yellowQuestion.getX()) && (mouse.getY() == yellowQuestion.getY())) {
        	mouse.changeSide();
        	return true;
        }
        
        for (int z = snake.getDots(); z > 0; z--) {

            if ((z > 1) && (mouse.getX() == x[z]) && (mouse.getY() == y[z])) {
            	mouse.changeSide();
            	return true;
            }
        }

        if (mouse.getY() >= B_HEIGHT) {
        	//mouse.changeSide();
        	return true;
        }

        if (mouse.getY() <= 0) {
        	//mouse.changeSide();
        	return true;
        }

        if (mouse.getX() >= B_WIDTH) {
        	//mouse.changeSide();
        	return true;
        }

        if (mouse.getX() <= 0) {
        	//mouse.changeSide();
        	return true;
        }
        return false;
        	
    }
    


    /*
     * If the apple collides with the head,
     * we increase the number of dots of the snake, add the score and play the sound of eating.
     * We call the Random() method in the apple which randomly positions a new apple object.
     */
    private void checkApple() {

        if ((x[0] == apple.getX()) && (y[0] == apple.getY())) {

            snake.setDots(snake.getDots()+1);
            playerScore+=apple.addPoints();
            SnakeView.updatescore();
            apple.random();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}
            
            

        }
        
    }
    

    /*
     * If the banana collides with the head,
     * we increase the number of dots of the snake, add the score and play the sound of eating.
     * We call the Random() method in the banana which randomly positions a new banana object.
     */
    
    private void checkBanana() {

        if ((x[0] == banana.getX()) && (y[0] == banana.getY())) {

        	snake.setDots(snake.getDots()+1);
            playerScore+=banana.addPoints();
            SnakeView.updatescore();
            banana.random();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}

        }
    }
    

    /*
     * If the pear collides with the head,
     * we increase the number of dots of the snake, add the score and play the sound of eating.
     * We call the Random() method in the pear which randomly positions a new pear object.
     */
    
    private void checkPear() {

        if ((x[0] == pear.getX()) && (y[0] == pear.getY())) {

        	snake.setDots(snake.getDots()+1);
            playerScore+=pear.addPoints();
            SnakeView.updatescore();
            pear.random();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}

        }
    }
    
    /*
     * If the banana collides with the head,
     * we increase the number of dots of the snake, add the score and play the sound of eating.
     * We call the Random() method in the banana which randomly positions a new banana object.
     */
    
    private void checkStrawberry() {

        if ((x[0] == strawberry.getX()) && (y[0] == strawberry.getY())) {
        	
        	if(snake.getDots()>2) {

        	snake.setDots(snake.getDots()-2);
        	}
        	else if(snake.getDots()==2) {

            	snake.setDots(snake.getDots()-1);
            	}
            strawberry.random();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}

        }
    }
    

    /*
     * If the question collides with the head,
     * we show the question, add the score and play the sound of eating.
     * We call the Random() method in the question which randomly positions a new question object.
     */
    
    private void checkWhiteQ() {

        if ((x[0] == whiteQuestion.getX()) && (y[0] == whiteQuestion.getY())) {
        	
        	playerScore+=whiteQuestion.getAnswerPoints(SnakeView.viewQuestion(whiteQuestion));
            SnakeView.updatescore();
            whiteQuestion.random();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}

        }

    }
    
    /*
     * If the question collides with the head,
     * we show the question, add the score and play the sound of eating.
     * We call the Random() method in the question which randomly positions a new question object.
     */
    
    private void checkRedQ() {

        if ((x[0] == redQuestion.getX()) && (y[0] == redQuestion.getY())) {

        	playerScore+=redQuestion.getAnswerPoints(SnakeView.viewQuestion(redQuestion));
            SnakeView.updatescore();
            redQuestion.random();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}

        }

    }
    
    /*
     * If the question collides with the head,
     * we show the question, add the score and play the sound of eating.
     * We call the Random() method in the question which randomly positions a new question object.
     */
    
    private void checkYellowQ() {

        if ((x[0] == yellowQuestion.getX()) && (y[0] == yellowQuestion.getY())) {

        	playerScore+=yellowQuestion.getAnswerPoints(SnakeView.viewQuestion(yellowQuestion));
            SnakeView.updatescore();
            yellowQuestion.random();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}

        } 


    }
    
    /*
     * If the mouse collides with the head,
     * we increase the dots of the snake by 2 add the score and play the sound of adding life if the eatins adds life.
     * We call the Random() method in the mouse which randomly positions a new mouse object.
     */
    
    private void checkMouse() {

        if ((x[0] == mouse.getX()) && (y[0] == mouse.getY())) {
        	
        	playerScore+=mouse.addPoints();
            SnakeView.updatescore();
            
            if(Setting.sound1 == true) {
            	soundManger1.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger1.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}
            
            if(numOFLifes<3) {
    		
            numOFLifes+=mouse.addLives();
            SnakeView.updateLives();
            
            if(Setting.sound1 == true) {
            	soundManger2.startSound();
        		new java.util.Timer().schedule( 
        		        new java.util.TimerTask() {
        					@Override
        		            public void run() {
                               soundManger2.pauseSound();
        		            }
        		        }, 
        		        500 
        				);
        		}
            
            }

            snake.setDots(snake.getDots()+2);
            mouse.random();
        }

    }


    /*
     * In the move() method we have the key algorithm of the game.
     * To understand it, look at how the snake is moving.
     * We control the head of the snake.
     * We can change its direction with the cursor keys.
     * The rest of the joints move one position up the chain.
     * The second joint moves where the first was, the third joint where the second was etc.
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
        
        checkMouse();
    }
    
    /*
     * In the checkCollision() method, 
     * we determine if the snake has hit itself or one of the walls.
     * If the snake hits one of its joints with its head if the player have more lives we minus one 
     * life if its the last life then the game is over
     */

    private void checkCollision() {

        for (int z = snake.getDots(); z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z]) && numOFLifes >0) {
            	numOFLifes--;
            	SnakeView.updateLives();
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
    		soundManger1.pauseSound();
    		soundManger2.pauseSound();

            if(numOFLifes==0) setGameOver(true);
        }
    }
    
    /*
     * pause game and sounds
     */
    public static void pause() {
    	
    	if(timer.isRunning()) {
    		timer.stop();
    		soundManger.pauseSound();

    		}
    	else {
    		timer.start();
    	    soundManger.startSound();
            if(Setting.sound == false) {
           	 soundManger.pauseSound();
            }
    	}
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
        	
        	
            checkApple();
            checkBanana();
            checkPear();
            
            checkRedQ();
            checkWhiteQ();
            checkYellowQ();
            checkStrawberry();
            
            
            
            checkCollision();
            move();
            
            checkMouseCollision();
            movemouse();
            
            checkMouse();

        }
        
        repaint();
    }

	public int getPlayerScore() {
		return playerScore;
	}

	public int getNumOFLifes() {
		return numOFLifes;
	}
	

	public boolean isGameOver() {
		return isGameOver;
	}

	public static void setGameOver(boolean isGameOver) {
		Board.isGameOver = isGameOver;
	}
	
}