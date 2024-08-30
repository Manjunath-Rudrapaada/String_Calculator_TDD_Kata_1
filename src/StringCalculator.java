

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	
	public int add(String inputString) {
		
		if (inputString.isEmpty()) {
			return 0;
		}
		
		if (inputString.length() == 1) {
			return parseSingleNumberInput(inputString);
		}
		
		String[] nums = checkForCustomDelimiterAndSplitTheString(inputString);
		
		List<String> numberList = checkForEmptyString(nums);
		
		List<String> negativeNumbers = checkForNegativeNumbers(numberList);
		if (!negativeNumbers.isEmpty()) {
			throwNegativeNumberException(negativeNumbers);
		}
		
		return calculateSum(numberList);
	}

	private int parseSingleNumberInput(String inputString) {
		if (!inputString.matches("\\d+")) { // regex to check if string contains number or a character
			System.out.println("Invalid Input :" + inputString);
			return -1;
		}
		
		return Integer.parseInt(inputString);
	}
	
	private List<String> checkForEmptyString(String[] nums) {
		return Arrays.stream(nums) 
				.filter(num -> !num.isEmpty())
				.collect(Collectors.toList());
	}
	
	private String[] checkForCustomDelimiterAndSplitTheString(String inputString) {
		String delimiter = ",|\\n";
		
		if (inputString.startsWith("//")) {
			int delimiterPatternEndIndex = inputString.indexOf("\n");
			delimiter = Pattern.quote(inputString.substring(2, delimiterPatternEndIndex));
			inputString = inputString.substring(delimiterPatternEndIndex + 1);
		}
		
		String[] nums = inputString.split(delimiter);
		return nums;
	}
	
	private List<String> checkForNegativeNumbers(List<String> numberList) {
		return numberList.stream()
				.filter(num -> Integer.valueOf(num) < 0)
				.collect(Collectors.toList());
	}
	
	private void throwNegativeNumberException(List<String> negativeNumbers) {
			StringBuilder sb = new StringBuilder("Negative numbers not allowed! ");
			sb.append(negativeNumbers);
			throw new IllegalArgumentException(sb.toString());
	}

	private int calculateSum(List<String> numberList) {
		return numberList.stream()
				.mapToInt(Integer::parseInt)
				.filter(num -> num <= 1000) // Ignore numbers > 1000
				.sum();
	}

}
