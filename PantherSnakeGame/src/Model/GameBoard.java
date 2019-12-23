//package Model;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.geom.Ellipse2D;
//import java.awt.geom.Rectangle2D;
//
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
//import Controller.SoundManger;
//
//
//@SuppressWarnings("serial")
//public class GameBoard extends JPanel implements ActionListener {
//
//
//
//
//int i ;
//
//		soundManger = new SoundManger(soundFilePath);
//
//		gameThread = new Timer(140, this);
//
//		timerThread = new Timer(1000, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				if (isGameOver()) {
//					stopGame();
//				}
//
//				timer++;
//			}
//		});
//
//		// timerThread.setLogTimers(true);
//		// gameThread.setLogTimers(true);
//
//		addKeyListener(inputManager);
//
//	}
//
///*	private int getDelay(int level) {
//
//
//		int delay = 0;
//		if (level == 1) {	
//			delay = 140;
//		} else if (level == 2) {
//			delay = 140;
//			
//		} else if (level == 3) {
//			delay = 140;
//		}else if (level == 4) {
//			delay = 140;
//		}
//		return delay;
//	}
//*/
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		doDrawing(g);
//	}
//	/*
//	 * initiate the full board with all the objects
//	 */
//
//
//		DrawStatusbar(g2);
//		DrawBoundry(g2);
//     	DrawSnake(g2);
//
//	}
//	//draw the boundary
//	public void DrawBoundry(Graphics2D g2) {
//		for (int i = 0; i < 120; i++) {
//			Rectangle2D.Double rect = new Rectangle2D.Double(227.0 - i,
//					127.0 - i, 624, 480);
//
//			g2.setColor(Color.YELLOW);
//			g2.draw(rect);
//
//		}
//	}
//
//
//	//draw the Status bar 
//	public void DrawStatusbar(Graphics2D g2) {
//		g2.setColor(Color.WHITE);
//		g2.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
//		g2.drawString("Snake Game", 400, 50);
//		g2.setColor(Color.YELLOW);
//		g2.drawString("Panther", 450, 100);
//
//		g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//		g2.setColor(Color.WHITE);
//		g2.drawString("Press Esc for exit !", 10, 20);
//		g2.drawString("Press Spacebar for pause !", 10, 50);
//
//		g2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		g2.drawString("Time: ", 210, 100);
//		g2.drawString("Your Score: ", 680, 100);
//		g2.drawString("Red Apple     = 10 points", 880, 200);
//		g2.drawString("Green Pear    = 20 points", 880, 300);
//		g2.drawString("Yellow Banana = 15 points", 880, 250);
//		g2.drawString("Gray Mouse    = 30 points", 880, 350);
//		g2.drawString("Lifes: ", 880, 550);
//		g2.drawString("Hight Score : " + playerScore, 880, 600);
//		g2.setColor(Color.BLUE);
//		g2.drawString("" + playerScore, 810, 100);
//		g2.drawString("" + timer, 270, 100);
//		g2.drawString("" + numOFLifes, 950, 550);
//		if (isGameOver()) {
//			g2.setColor(Color.RED);
//			g2.drawString("Game Over!", 480, 250);
//			g2.drawString("Your Score : " + playerScore, 470, 300);
//			g2.drawString("To Start A New Game Press On File :)", 350, 350);
//			g2.drawString("Your Time : " + timer, 470, 400);
//		} else if (!isGameRunning()) {
//			g2.setColor(Color.GREEN);
//			g2.drawString("Press SpaceBar to Start Game !", 380, 550);
//		}
//
//	}
//
//
//	/*
//	 * the method checks if the snake collisions with the boundary or with her self
//	 * and updates or finishes the game 
//	 * and check when the snake eat any type of food and add to the score the appropriate 
//	 * points and add it again
//	 */
//	public void checkCollision() {
//
//		if (isSelfCollisioned() || isBoundaryCollisioned() && numOFLifes > 0) {
//			
//			numOFLifes = numOFLifes -1;
//			if(numOFLifes == 1) {
//				isGameOver = true;
//			}
//			isGameOver = false;
//			contGame();
//
//
//		}
//		else if (isSelfCollisioned() || isBoundaryCollisioned() && numOFLifes == 0)
//		{
//
//			isGameOver = true;
//			stopGame();
//
//		}
//
//		if (isFoodCollisioned()) {
//
//			snake.eat();
//			snakeFood = new Apple();
//			playerScore += 10;
//		}
//		
//		if (isFoodCollisioned2()) {
//
//			snake.eat2();
//			snakeFood2 = new Pear();
//			playerScore += 20;
//		}
//		
//		if (isFoodCollisioned3()) {
//
//			snake.eat3();
//			snakeFood3 = new Banana();
//			playerScore += 15;
//		}
//		
//		if (isFoodCollisioned4()) {
//
//			snake.eat4();
//			if(numOFLifes < 3 && numOFLifes > 0) {
//			numOFLifes ++;
//			}
//			snakeFood4 = new Mouse();
//			playerScore += 30;
//		}
//	}
//
//
//
//
//	/*
//	 *Starts new game , if another game is on progress the game starts again 
//	 */
//	public void startGame() {
//
//		if (gameThread.isRunning()) {
//			gameThread.restart();
//			timerThread.restart();
//			soundManger.startSound();
//
//		} else {
//			gameThread.start();
//			timerThread.start();
//			soundManger.startSound();
//		}
//
//	}
//	/*
//	 * pausing the game
//	 */
//	public void pauseGame() {
//
//		gameThread.stop();
//		timerThread.stop();
//		soundManger.pauseSound();
//		repaint();
//
//	}
//	/*
//	 * continue the game after pausing
//	 */
//	public void contGame() {
//		
//		gameThread.stop();
//		timerThread.stop();
//		isGameRunning();
//		if(gameThread.isRunning()) {
//			gameThread.restart();
//		} else pauseGame();
//		}
//		
//	/*
//	 * Stopping the game
//	 */
//	public void stopGame() {
//
//		gameThread.stop();
//		timerThread.stop();
//		soundManger.stopSound();
//
//	}
//	/*
//	 * checks if the game is in progress 
//	 */
//	public boolean isGameRunning() {
//		return gameThread.isRunning() && !isGameOver();
//	}
//	/*
//	 * checks if the game Ended 
//	 */
//	public boolean isGameOver() {
//		return isGameOver;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//
//		repaint();
//
//	}
//
//}
