package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Mouse;

class MouseTest {

	@Test
	public void checkMousePoints() {
		Mouse mouse = new Mouse();
		assertEquals(30, mouse.addPoints());
	}

}