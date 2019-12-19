package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.InputManager;
import Controller.SoundManger;

public class Board extends JPanel implements ActionListener {
	
	/**
	 * The B_WIDTH and B_HEIGHT constants determine the size of the board.
	 * The DOT_SIZE is the size of the apple and the dot of the snake.
	 * The ALL_DOTS constant defines the maximum number of possible dots on the board (3600 = (600*600)/(10*10)).
	 * The RAND_POS constant is used to calculate a random position for an apple 60 .
	 * The DELAY constant determines the speed of the game.
	 */

    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    public static final int DOT_SIZE = 10;
    private final int ALL_DOTS = 3600;
    public static final int RAND_POS = 60;
    private final int DELAY = 140;
    
	/** Creates a new instance of sysData */
    
//	private InputManager inputManager;
//	private SoundManger soundManger = null;
//	private Timer gameThread;
//	private Timer timerThread;
//
//	private boolean isGameOver = false;
//
//	private int timer1 = 0;
//	private int playerScore = 0;
//	private int numOFLifes = 3;
//	 private String soundFilePath = "start.wav";


    
    /**
     * These two arrays store the x and y coordinates of all joints of a snake.
     */

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    
    private Apple apple = new Apple();
    private Banana banana = new Banana();
    private Pear pear = new Pear();



    private int whiteQ_x;
    private int whiteQ_y;
    private int yellowQ_x;
    private int yellowQ_y;
    private int redQ_x;
    private int redQ_y;
    private int mouse_x;
    private int mouse_y;

    public static boolean leftDirection = false;
    public static boolean rightDirection = true;
    public static boolean upDirection = false;
    public static boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    public static Image head;
    
    private Image mouse_down;
    private Image mouse_up;
    private Image mouse_right;
    private Image mouse_left;
    
    private Image whiteQ;
    private Image yellowQ;
    private Image redQ;
    

    public Board() {
        
        initBoard();
    }
    
    private void initBoard() {

        addKeyListener(new InputManager());
        setBackground(Color.WHITE);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }
    
    /**
     * In the loadImages() method we get the images for the game.
     * The ImageIcon class is used for displaying PNG images.
     */

    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/images/dot.png");
        ball = iid.getImage();

       
        

        
        ImageIcon iimd = new ImageIcon("src/images/mouse_down.png");
        mouse_down = iimd.getImage();
        ImageIcon iimr = new ImageIcon("src/images/mouse_right.png");
        mouse_down = iimr.getImage();
        ImageIcon iiml = new ImageIcon("src/images/mouse_left.png");
        mouse_down = iiml.getImage();
        ImageIcon iimu = new ImageIcon("src/images/mouse_up.png");
        mouse_down = iimu.getImage();
        
        
        ImageIcon iiw = new ImageIcon("src/images/whiteQ.png");
        whiteQ = iiw.getImage();
        
        ImageIcon iiy = new ImageIcon("src/images/yellowQ.png");
        yellowQ = iiy.getImage();
        
        ImageIcon iir = new ImageIcon("src/images/redQ.png");
        redQ = iir.getImage();

        ImageIcon iih = new ImageIcon("src/images/headR.png");
        head = iih.getImage();
        
    }
    
    /**
     * In the initGame() method we create the snake,
     *  randomly locate an apple on the board, and start the timer.
     */

    private void initGame() {

        dots = 1;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        locateF();

        timer = new Timer(DELAY, this);
        timer.start();
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
            
            
            g.drawImage(whiteQ, whiteQ_x, whiteQ_y, this);
            g.drawImage(yellowQ, yellowQ_x, yellowQ_y, this);
            g.drawImage(redQ, redQ_x, redQ_y, this);
            
            
            g.drawImage(mouse_down, mouse_x, mouse_y, this);
            g.drawImage(mouse_left, mouse_x, mouse_y, this);
            g.drawImage(mouse_right, mouse_x, mouse_y, this);
            g.drawImage(mouse_up, mouse_x, mouse_y, this);



            
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

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
    }

    /**
     * If the apple collides with the head,
       we increase the number of joints of the snake.
        We call the locateApple() method which randomly positions a new apple object.
     */
    private void checkApple() {

        if ((x[0] == apple.getX()) && (y[0] == apple.getY())) {

            dots++;
            apple.random();
        }
    }
    private void checkBanana() {

        if ((x[0] == banana.getX()) && (y[0] == banana.getY())) {

            dots++;
            banana.random();
        }
    }
    private void checkPear() {

        if ((x[0] == pear.getX()) && (y[0] == pear.getY())) {

            dots++;
            pear.random();
        }
    }
    
    
    
    private void checkWQ() {

        if ((x[0] == whiteQ_x) && (y[0] == whiteQ_y)) {

            dots++;
            locateF();
        }
    }
    private void checkRQ() {

        if ((x[0] == redQ_x) && (y[0] == redQ_y)) {

            dots++;
            locateF();
        }
    }
    private void checkYQ() {

        if ((x[0] == yellowQ_x) && (y[0] == yellowQ_y)) {

            dots++;
            locateF();
        }
    }
    
    private void checkM() {

        if ((x[0] == mouse_x) && (y[0] == mouse_y)) {
        	dots++;
            dots++;
            locateF();
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

        for (int z = dots; z > 0; z--) {
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

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateF() {
    	 

        
        int m = (int) (Math.random() * RAND_POS);
        mouse_x = ((m * DOT_SIZE));

        m = (int) (Math.random() * RAND_POS);
        mouse_y = ((m * DOT_SIZE));
        
        
        
        int rq = (int) (Math.random() * RAND_POS);
        redQ_x = ((rq * DOT_SIZE));

        rq = (int) (Math.random() * RAND_POS);
        redQ_y = ((rq * DOT_SIZE));
        
        
        
        int wq = (int) (Math.random() * RAND_POS);
        whiteQ_x = ((wq * DOT_SIZE));

        wq = (int) (Math.random() * RAND_POS);
        whiteQ_y = ((wq * DOT_SIZE));
        
        
        
        int yq = (int) (Math.random() * RAND_POS);
        yellowQ_x = ((yq * DOT_SIZE));

        yq = (int) (Math.random() * RAND_POS);
        yellowQ_y = ((yq * DOT_SIZE));
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkBanana();
            checkPear();
            
            
            checkRQ();
            checkWQ();
            checkYQ();
            
            
            checkM();
            
            checkCollision();
            move();
        }

        repaint();
    }

   
    }