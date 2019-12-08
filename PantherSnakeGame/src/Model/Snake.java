
package Model;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;


public class Snake {

	private static final int DEFAULT_SNAKE_LENGTH = 3;  
	private static final int DEFAULT_SNAKE_DIRECTION = 3; //Right direction

	private ArrayList<Ellipse2D.Double> snakeBody = new ArrayList<Ellipse2D.Double>();

	private int direction;
	/* 
	 * initiate new snake in the default length and direction
	 */
	public Snake() {

		direction = DEFAULT_SNAKE_DIRECTION;

		for (int i = 0; i < DEFAULT_SNAKE_LENGTH; i++) {
			snakeBody.add(new Ellipse2D.Double(355 - i * 16, 191, 16, 16));
		}
	}
	/*
	 * set the direction of the snake
	 */
	public void setDirection(int dir) {
		if (direction >= 3 && dir < 3) {
			this.direction = dir;
		} else if (direction <= 2 && dir > 2) {
			this.direction = dir;
		}
	}
	/*
	 * define the movement of the snake
	 */
	public void move() {
		for (int i = getLength() - 1; i > 0; i--) {
			snakeBody.set(i, (Ellipse2D.Double) snakeBody.get(i - 1));
		}

		if (direction == 1) {
			decreaseY();
		} else if (direction == 2) {
			increaseY();
		} else if (direction == 3) {
			increaseX();
		} else if (direction == 4) {
			decreaseX();
		}
	}
	/*
	 * add length of 1 to the snake
	 */
	public void eat() {

		snakeBody.add(snakeBody.get(getLength() - 1));
	}
	
	public void eat2() {

		snakeBody.add(snakeBody.get(getLength() - 1));
	}
	
	public void eat3() {

		snakeBody.add(snakeBody.get(getLength() - 1));
	}
	/*
	 * add length of 2 to the snake
	 */
	public void eat4() {

		snakeBody.add(snakeBody.get(getLength() -1));
		snakeBody.add(snakeBody.get(getLength() -1));
	}
	/*
	 * move Upward
	 * takes the tail and put it in front of the head
	 */
	public void increaseY() {
		Ellipse2D.Double temp = (Ellipse2D.Double) snakeBody.get(0);
		Ellipse2D.Double newHead = new Ellipse2D.Double(temp.x, temp.y + 16,
				temp.getWidth(), temp.getHeight());

		snakeBody.set(0, (Ellipse2D.Double) newHead);

	}
	/*
	 * move Downward
	 * takes the tail and put it in front of the head
	 */
	public void decreaseY() {
		Ellipse2D.Double temp = (Ellipse2D.Double) snakeBody.get(0);
		Ellipse2D.Double newHead = new Ellipse2D.Double(temp.x, temp.y - 16,
				temp.getWidth(), temp.getHeight());

		snakeBody.set(0, (Ellipse2D.Double) newHead);
	}
	/*
	 * move Right  
	 * takes the tail and put it in front of the head
	 */
	public void increaseX() {
		Ellipse2D.Double temp = (Ellipse2D.Double) snakeBody.get(0);
		Ellipse2D.Double newHead = new Ellipse2D.Double(temp.x + 16, temp.y,
				temp.getWidth(), temp.getHeight());

		snakeBody.set(0, (Ellipse2D.Double) newHead);
	}
	/*
	 * move leftward 
	 * takes the tail and put it in front of the head
	 */
	public void decreaseX() {
		Ellipse2D.Double temp = (Ellipse2D.Double) snakeBody.get(0);
		Ellipse2D.Double newHead = new Ellipse2D.Double(temp.x - 16, temp.y,
				temp.getWidth(), temp.getHeight());

		snakeBody.set(0, (Ellipse2D.Double) newHead);
	}
	/*
	 * returns the snake body
	 */
	public ArrayList<Ellipse2D.Double> getSnakeBody() {
		return snakeBody;
	}
	/*
	 * returns the snake length
	 */
	public int getLength() {
		return snakeBody.size();
	}
	/*
	 * return the snake direction
	 */
	public int getDirection() {

		return direction;
	}
	/*
	 * return the head of the snake
	 */
	public Ellipse2D.Double getHead() {

		return snakeBody.get(0);

	}

}
