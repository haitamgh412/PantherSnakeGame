package tests;

import recources.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class CheckQuestionNameFile {

	@Test
	void test() {
		assertEquals("src\\resources\\questions.json", Constants.QUESTIONFILENAME );
	}

}