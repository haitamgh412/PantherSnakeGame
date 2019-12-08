
package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManger implements KeyListener {

	private sysData gameBoard;

	public InputManger(sysData gameBoard) {
		this.gameBoard = gameBoard;
	}

	public void keyTyped(KeyEvent e) {
	}

	/*
	 * Manages what the game have to do when the player presses on the keyboard's keys 
	 * in different situations
	 * 
	 */
	
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {

			gameBoard.changeSnakeDirection(1);

		} else if (key == KeyEvent.VK_DOWN) {

			gameBoard.changeSnakeDirection(2);

		} else if (key == KeyEvent.VK_RIGHT) {

			gameBoard.changeSnakeDirection(3);

		} else if (key == KeyEvent.VK_LEFT) {

			gameBoard.changeSnakeDirection(4);

		} else if (key == KeyEvent.VK_SPACE) {

			if (gameBoard.isGameRunning()) {
				gameBoard.pauseGame();

			} else {
				gameBoard.startGame();

			}

		} else if (key == KeyEvent.VK_ESCAPE) {

			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
	}

}
