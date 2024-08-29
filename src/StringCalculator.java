

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
			if (!inputString.matches("\\d+")) {
				System.out.println("Invalid Input :" + inputString);
				return -1;
			}
			
			int result = Integer.parseInt(inputString);
			return result;
		}
		
		String delimiter = ",|\\n";
		
		if (inputString.startsWith("//")) {
			int delimiterPatternEndIndex = inputString.indexOf("\n");
			delimiter = Pattern.quote(inputString.substring(2, delimiterPatternEndIndex));
			inputString = inputString.substring(delimiterPatternEndIndex + 1);
		}
		
		String[] nums = inputString.split(delimiter);
		
		List<String> numberList = Arrays.stream(nums) 
				.filter(num -> !num.isEmpty()).collect(Collectors.toList());
		
		List<String> negativeNumbers = numberList.stream()
				.filter(num -> Integer.valueOf(num) < 0)
				.collect(Collectors.toList());
		
		if (!negativeNumbers.isEmpty()) {
			StringBuilder sb = new StringBuilder("Negative numbers not allowed! ");
			sb.append(negativeNumbers);
			throw new IllegalArgumentException(sb.toString());
		}
		
		int sum = numberList.stream()
				.mapToInt(Integer::parseInt)
				.sum();
		
		return sum;
	}

}
