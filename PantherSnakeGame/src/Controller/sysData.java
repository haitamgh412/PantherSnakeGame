package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.Timer;

import Model.Snake;
import View.SoundManger;
import Model.Apple;
import Model.Pear;
import Model.Banana;
import Model.Mouse;


@SuppressWarnings("serial")
public class sysData extends JPanel implements ActionListener {

	/** Creates a new instance of sysData */

	private Snake snake;
	private Apple snakeFood;
	private Pear snakeFood2;
	private Banana snakeFood3;
	private Mouse snakeFood4;
	private InputManger inputManager;
	private SoundManger soundManger = null;

	private Timer gameThread;
	private Timer timerThread;

	private boolean isGameOver = false;

	private int timer = 0;
	private int playerScore = 0;
	private int numOFLifes = 3;

	 private String soundFilePath = "start.wav";

	public sysData(int level) {

		setBackground(Color.BLACK);
		setFocusable(true);

		snake = new Snake();
		snakeFood = new Apple();
		snakeFood2 = new Pear();
		snakeFood3 = new Banana();
		snakeFood4 = new Mouse();

		inputManager = new InputManger(this);
		soundManger = new SoundManger(soundFilePath);

		gameThread = new Timer(140, this);

		timerThread = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (isGameOver()) {
					stopGame();
				}

				timer++;
			}
		});

		// timerThread.setLogTimers(true);
		// gameThread.setLogTimers(true);

		addKeyListener(inputManager);

	}

/*	private int getDelay(int level) {


		int delay = 0;
		if (level == 1) {	
			delay = 140;
		} else if (level == 2) {
			delay = 140;
			
		} else if (level == 3) {
			delay = 140;
		}else if (level == 4) {
			delay = 140;
		}
		return delay;
	}
*/
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}
	/*
	 * initiate the full board with all the objects
	 */
	public void doDrawing(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		if (isGameRunning()) {

			snake.move();

			checkCollision();

			DrawSnakeFood(g2);
			DrawSnakeFood2(g2);
			DrawSnakeFood3(g2);
			DrawSnakeFood4(g2);

		}

		DrawStatusbar(g2);
		DrawBoundry(g2);
     	DrawSnake(g2);

	}
	//draw the boundary
	public void DrawBoundry(Graphics2D g2) {
		for (int i = 0; i < 17; i++) {
			Rectangle2D.Double rect = new Rectangle2D.Double(227.0 - i,
					127.0 - i, 624, 480);

			g2.setColor(Color.YELLOW);
			g2.draw(rect);

		}
	}
	//draw the snake
	public void DrawSnake(Graphics2D g2) {

		for (int i = 0; i < snake.getSnakeBody().size(); i++) {

			if (i == 0) {
				g2.setColor(Color.WHITE);
				g2.fill(snake.getSnakeBody().get(i));

			} else {
				g2.setColor(Color.ORANGE);
				g2.draw(snake.getSnakeBody().get(i));
			}

		}
	}
	//draw the apple
	public void DrawSnakeFood(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fill(snakeFood.getFood());
	}
	//draw the pear
	public void DrawSnakeFood2(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		g2.fill(snakeFood2.getFood2());
	}
	//draw the banana
	public void DrawSnakeFood3(Graphics2D g2) {
		g2.setColor(Color.YELLOW);
		g2.fill(snakeFood3.getFood3());
	}
	//draw the mouse
	public void DrawSnakeFood4(Graphics2D g2) {
		g2.setColor(Color.GRAY);
		g2.fill(snakeFood4.getFood4());
	}
	//draw the Status bar 
	public void DrawStatusbar(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		g2.drawString("Snake Game", 400, 50);
		g2.setColor(Color.YELLOW);
		g2.drawString("Panther", 450, 100);

		g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		g2.setColor(Color.WHITE);
		g2.drawString("Press Esc for exit !", 10, 20);
		g2.drawString("Press Spacebar for pause !", 10, 50);

		g2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g2.drawString("Time: ", 210, 100);
		g2.drawString("Your Score: ", 680, 100);
		g2.drawString("Red Apple     = 10 points", 880, 200);
		g2.drawString("Green Pear    = 20 points", 880, 300);
		g2.drawString("Yellow Banana = 15 points", 880, 250);
		g2.drawString("Gray Mouse    = 30 points", 880, 350);
		g2.drawString("Lifes: ", 880, 550);
		g2.drawString("Hight Score : " + playerScore, 880, 600);
		g2.setColor(Color.BLUE);
		g2.drawString("" + playerScore, 810, 100);
		g2.drawString("" + timer, 270, 100);
		g2.drawString("" + numOFLifes, 950, 550);
		if (isGameOver()) {
			g2.setColor(Color.RED);
			g2.drawString("Game Over!", 480, 250);
			g2.drawString("Your Score : " + playerScore, 470, 300);
			g2.drawString("To Start A New Game Press On File :)", 350, 350);
			g2.drawString("Your Time : " + timer, 470, 400);
		} else if (!isGameRunning()) {
			g2.setColor(Color.GREEN);
			g2.drawString("Press SpaceBar to Start Game !", 380, 550);
		}

	}
	/* 
	 * change the direction of the snake
	 */
	public void changeSnakeDirection(int direction) {
		this.snake.setDirection(direction);
	}

	/*
	 * the method checks if the snake collisions with the boundary or with her self
	 * and updates or finishes the game 
	 * and check when the snake eat any type of food and add to the score the appropriate 
	 * points and add it again
	 */
	public void checkCollision() {

		if (isSelfCollisioned() || isBoundaryCollisioned() && numOFLifes > 0) {
			
			numOFLifes = numOFLifes -1;
			if(numOFLifes == 1) {
				isGameOver = true;
			}
			isGameOver = false;
			contGame();


		}
		else if (isSelfCollisioned() || isBoundaryCollisioned() && numOFLifes == 0)
		{

			isGameOver = true;
			stopGame();

		}

		if (isFoodCollisioned()) {

			snake.eat();
			snakeFood = new Apple();
			playerScore += 10;
		}
		
		if (isFoodCollisioned2()) {

			snake.eat2();
			snakeFood2 = new Pear();
			playerScore += 20;
		}
		
		if (isFoodCollisioned3()) {

			snake.eat3();
			snakeFood3 = new Banana();
			playerScore += 15;
		}
		
		if (isFoodCollisioned4()) {

			snake.eat4();
			if(numOFLifes < 3 && numOFLifes > 0) {
			numOFLifes ++;
			}
			snakeFood4 = new Mouse();
			playerScore += 30;
		}
	}

	/*
	 * checks if the snakes collisions with the boundary according to the boundary coordinates
	 */
	public boolean isBoundaryCollisioned() {
		if (snake.getDirection() == 1) {
			double centerY = ((Ellipse2D.Double) snake.getSnakeBody().get(0))
					.getMinY();
			return centerY < 127;
		} else if (snake.getDirection() == 2) {
			double centerY = ((Ellipse2D.Double) snake.getSnakeBody().get(0))
					.getMaxY();
			return centerY > 591;
		} else if (snake.getDirection() == 3) {
			double centerX = ((Ellipse2D.Double) snake.getSnakeBody().get(0)).x;
			return centerX > 819;
		} else if (snake.getDirection() == 4) {
			double centerX = ((Ellipse2D.Double) snake.getSnakeBody().get(0))
					.getMinX();
			return centerX < 227.0;
		}
		return false;
	}

	/*
	 * check if the the user press up if on the upper point exist any of the snake part
	 * then there is collision .
	 * the same thing for the four directions
	 */
	public boolean isSelfCollisioned() {

		if (snake.getDirection() == 1) {
			for (int i = 1; i < snake.getSnakeBody().size(); i++) {
				if ((((Ellipse2D.Double) snake.getSnakeBody().get(0)).getMinY() == ((Ellipse2D.Double) snake
						.getSnakeBody().get(i)).getMaxY())
						&& (((Ellipse2D.Double) snake.getSnakeBody().get(0))
								.getCenterX() == ((Ellipse2D.Double) snake
								.getSnakeBody().get(i)).getCenterX())) {
					return true;
				}
			}

		} else if (snake.getDirection() == 2) {
			for (int i = 1; i < snake.getSnakeBody().size(); i++) {
				if ((((Ellipse2D.Double) snake.getSnakeBody().get(0)).getMaxY() == ((Ellipse2D.Double) snake
						.getSnakeBody().get(i)).getMinY())
						&& (((Ellipse2D.Double) snake.getSnakeBody().get(0))
								.getCenterX() == ((Ellipse2D.Double) snake
								.getSnakeBody().get(i)).getCenterX())) {
					return true;
				}
			}

		} else if (snake.getDirection() == 3) {
			for (int i = 1; i < snake.getSnakeBody().size(); i++) {
				if ((((Ellipse2D.Double) snake.getSnakeBody().get(0)).getMaxX() == ((Ellipse2D.Double) snake
						.getSnakeBody().get(i)).getMinX())
						&& (((Ellipse2D.Double) snake.getSnakeBody().get(0))
								.getCenterY() == ((Ellipse2D.Double) snake
								.getSnakeBody().get(i)).getCenterY())) {
					return true;
				}
			}

		} else if (snake.getDirection() == 4) {
			for (int i = 1; i < snake.getSnakeBody().size(); i++) {
				if ((((Ellipse2D.Double) snake.getSnakeBody().get(0)).getMinX() == ((Ellipse2D.Double) snake
						.getSnakeBody().get(i)).getMaxX())
						&& (((Ellipse2D.Double) snake.getSnakeBody().get(0))
								.getCenterY() == ((Ellipse2D.Double) snake
								.getSnakeBody().get(i)).getCenterY())) {
					return true;
				}
			}
		}

		return false;

	}

	/*
	 * the method checks if the snake ate Apple and return true in any step
	 */
	public boolean isFoodCollisioned() {

		boolean collisionedWithFood = false;

		int direction = snake.getDirection();

		Ellipse2D.Double head = snake.getHead();

		if (direction == 1) {
			if ((head.getCenterY() == snakeFood.getFood().getCenterY())
					&& (head.getCenterX() == snakeFood.getFood().getCenterX())) {
				collisionedWithFood = true;
			} else
				collisionedWithFood = false;
		} else if (direction == 2) {

			if ((head.getCenterY() == snakeFood.getFood().getCenterY())
					&& (head.getCenterX() == snakeFood.getFood().getCenterX())) {
				collisionedWithFood = true;
			} else
				collisionedWithFood = false;

		} else if (direction == 3) {
			if ((head.getCenterX() == snakeFood.getFood().getCenterX())
					&& (head.getCenterY() == snakeFood.getFood().getCenterY())) {
				collisionedWithFood = true;
			} else
				collisionedWithFood = false;
		} else if (direction == 4) {
			if ((head.getCenterX() == snakeFood.getFood().getCenterX())
					&& (head.getCenterY() == snakeFood.getFood().getCenterY())) {
				collisionedWithFood = true;
			} else
				collisionedWithFood = false;
		}

		return collisionedWithFood;

	}
	/*
	 * the method checks if the snake ate Pear and return true in any step
	 */
	public boolean isFoodCollisioned2() {

		boolean collisionedWithFood2 = false;

		int direction = snake.getDirection();

		Ellipse2D.Double head = snake.getHead();

		if (direction == 1) {
			if ((head.getCenterY() == snakeFood2.getFood2().getCenterY())
					&& (head.getCenterX() == snakeFood2.getFood2().getCenterX())) {
				collisionedWithFood2 = true;
			} else
				collisionedWithFood2 = false;
		} else if (direction == 2) {

			if ((head.getCenterY() == snakeFood2.getFood2().getCenterY())
					&& (head.getCenterX() == snakeFood2.getFood2().getCenterX())) {
				collisionedWithFood2 = true;
			} else
				collisionedWithFood2 = false;

		} else if (direction == 3) {
			if ((head.getCenterX() == snakeFood2.getFood2().getCenterX())
					&& (head.getCenterY() == snakeFood2.getFood2().getCenterY())) {
				collisionedWithFood2 = true;
			} else
				collisionedWithFood2 = false;
		} else if (direction == 4) {
			if ((head.getCenterX() == snakeFood2.getFood2().getCenterX())
					&& (head.getCenterY() == snakeFood2.getFood2().getCenterY())) {
				collisionedWithFood2 = true;
			} else
				collisionedWithFood2 = false;
		}

		return collisionedWithFood2;

	}
	/*
	 * the method checks if the snake ate Banana and return true in any step
	 */
	public boolean isFoodCollisioned3() {

		boolean collisionedWithFood3 = false;

		int direction = snake.getDirection();

		Ellipse2D.Double head = snake.getHead();

		if (direction == 1) {
			if ((head.getCenterY() == snakeFood3.getFood3().getCenterY())
					&& (head.getCenterX() == snakeFood3.getFood3().getCenterX())) {
				collisionedWithFood3 = true;
			} else
				collisionedWithFood3 = false;
		} else if (direction == 2) {

			if ((head.getCenterY() == snakeFood3.getFood3().getCenterY())
					&& (head.getCenterX() == snakeFood3.getFood3().getCenterX())) {
				collisionedWithFood3 = true;
			} else
				collisionedWithFood3 = false;

		} else if (direction == 3) {
			if ((head.getCenterX() == snakeFood3.getFood3().getCenterX())
					&& (head.getCenterY() == snakeFood3.getFood3().getCenterY())) {
				collisionedWithFood3 = true;
			} else
				collisionedWithFood3 = false;
		} else if (direction == 4) {
			if ((head.getCenterX() == snakeFood3.getFood3().getCenterX())
					&& (head.getCenterY() == snakeFood3.getFood3().getCenterY())) {
				collisionedWithFood3 = true;
			} else
				collisionedWithFood3 = false;
		}

		return collisionedWithFood3;

	}
	/*
	 * the method checks if the snake ate Mouse and return true in any step
	 */
	public boolean isFoodCollisioned4() {

		boolean collisionedWithFood4 = false;

		int direction = snake.getDirection();

		Ellipse2D.Double head = snake.getHead();

		if (direction == 1) {
			if ((head.getCenterY() == snakeFood4.getFood4().getCenterY())
					&& (head.getCenterX() == snakeFood4.getFood4().getCenterX())) {
				collisionedWithFood4 = true;
			} else
				collisionedWithFood4 = false;
		} else if (direction == 2) {

			if ((head.getCenterY() == snakeFood4.getFood4().getCenterY())
					&& (head.getCenterX() == snakeFood4.getFood4().getCenterX())) {
				collisionedWithFood4 = true;
			} else
				collisionedWithFood4 = false;

		} else if (direction == 3) {
			if ((head.getCenterX() == snakeFood4.getFood4().getCenterX())
					&& (head.getCenterY() == snakeFood4.getFood4().getCenterY())) {
				collisionedWithFood4 = true;
			} else
				collisionedWithFood4 = false;
		} else if (direction == 4) {
			if ((head.getCenterX() == snakeFood4.getFood4().getCenterX())
					&& (head.getCenterY() == snakeFood4.getFood4().getCenterY())) {
				collisionedWithFood4 = true;
			} else
				collisionedWithFood4 = false;
		}

		return collisionedWithFood4;

	}
	/*
	 *Starts new game , if another game is on progress the game starts again 
	 */
	public void startGame() {

		if (gameThread.isRunning()) {
			gameThread.restart();
			timerThread.restart();
			soundManger.startSound();

		} else {
			gameThread.start();
			timerThread.start();
			soundManger.startSound();
		}

	}
	/*
	 * pausing the game
	 */
	public void pauseGame() {

		gameThread.stop();
		timerThread.stop();
		soundManger.pauseSound();
		repaint();

	}
	/*
	 * continue the game after pausing
	 */
	public void contGame() {
		
		gameThread.stop();
		timerThread.stop();
		isGameRunning();
		if(gameThread.isRunning()) {
			gameThread.restart();
		} else pauseGame();
		}
		
	/*
	 * Stopping the game
	 */
	public void stopGame() {

		gameThread.stop();
		timerThread.stop();
		soundManger.stopSound();

	}
	/*
	 * checks if the game is in progress 
	 */
	public boolean isGameRunning() {
		return gameThread.isRunning() && !isGameOver();
	}
	/*
	 * checks if the game Ended 
	 */
	public boolean isGameOver() {
		return isGameOver;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();

	}

}
