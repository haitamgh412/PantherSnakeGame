package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Model.Apple;
import Model.Banana;
import Model.Pear;

public class FruitsTests {
	
	@Test
	public void checkBananPoints() {
		Banana banana = new Banana();
		assertEquals(15, banana.addPoints());
	}
	
	@Test
	public void checkApplePoints() {
		Apple apple = new Apple();
		assertEquals(10, apple.addPoints());
	}
	
	@Test
	public void checkPearPoints() {
		Pear pear = new Pear();
		assertEquals(20, pear.addPoints());
	}

	
}