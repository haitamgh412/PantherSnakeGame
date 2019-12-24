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
//public class GameBoard extends JPanel implements ActionListener {
//
//
//
//		soundManger = new SoundManger(soundFilePath);
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
//		//
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
//}
