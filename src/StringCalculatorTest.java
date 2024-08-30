

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void testAddEmptyString() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0, stringCalculator.add(""));
	}
	
	@Test
	void testAddOneNumberString() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(23, stringCalculator.add("23"));
	}
	
	@Test
	void testAddStringWithoutNumber() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(-1, stringCalculator.add("s"));
	}
	
	@Test
	void testAddTwoNumbersString() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(40, stringCalculator.add("23,17"));
	}
	
	@Test
	void testAddMultipleNumbersString() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(40, stringCalculator.add("10,15,5,6,4"));
		assertEquals(69, stringCalculator.add("3,1,5,11,25,10,8,6"));
	}
	
	@Test
	void testAddMultipleNumbersStringWithEmptyStringsInBetween() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(40, stringCalculator.add(",10,15,5,,6,4,"));
	}
	
	@Test
	void testAddStringWithNewLineDelimiter() { 
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(21, stringCalculator.add("1,2,3\n4\n5,6"));
	}
	
	@Test
	void testAddStringWithCommaAndNewLineDelimiterTogether() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(21, stringCalculator.add("1,2,3,\n4\n,5,6"));
	}
	
	@Test
	void testAddStringWithCustomDelimiterAsterisk() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(10, stringCalculator.add("//*\n1*2*3*4"));
	}
	
	@Test
	void testAddStringWithCustomDelimiterColon() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(15, stringCalculator.add("//:\n1:2:3:4:5"));
	}
	
	@Test
	void testAddStringWithCustomDelimiterSemiColon() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(15, stringCalculator.add("//;\n1;2;3;4;5"));
	}
	
	@Test
	void testAddStringWithNegativeNumbers() {
		StringCalculator stringCalculator = new StringCalculator();
		stringCalculator.add("1,2,-3,4,-5,-6");
	}

	@Test
	void testAddStringContainingNumbersGreaterThanThousand() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(2331,stringCalculator.add("1,2,3,4,1000,5,1010,6,980,330,2024"));
	}
	
}
