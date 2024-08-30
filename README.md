String Calculator TDD Kata 1 Assessment
 
# This is a Simple String Calculator
 
## The program can take unknown amount of numbers with different delimiters and return their sum.


## Features used:
### Stream API for parallel processing to calculate the Sum of numbers
### Pattern Matching


## Test Cases:

### testAddEmptyString() 
	// Empty String
	
### testAddOneNumberString() 
	// String containing only one number
		
### testAddStringWithoutNumber() 
	// String containing only one Character not Integer

### testAddTwoNumbersString() 
	// String containing only two numbers separated by comma

### testAddMultipleNumbersString() 
	// String containing multiple numbers separated by comma

### testAddMultipleNumbersStringWithEmptyStringsInBetween() 
	// String containing numbers and empty strings in between
	
### testAddStringWithNewLineDelimiter() 
	// String with "\n" as a delimiter
	
### testAddStringWithCommaAndNewLineDelimiterTogether() 
	// String containing "," and "\n" as delimiters
	
### testAddStringWithCustomDelimiterAsterisk() 
	// String with custom delimiter "*"

### testAddStringWithCustomDelimiterColon() 
	// String with custom delimiter ":"
	
### testAddStringWithCustomDelimiterSemiColon() 
	// String with custom delimiter ";"

### testAddStringWithNegativeNumbers() 
	// String containing negative numbers (Test case fails since we are throwing Exception)
	
### testAddStringContainingNumbersGreaterThanThousand()
	// Numbers bigger than 1000 are ignored
