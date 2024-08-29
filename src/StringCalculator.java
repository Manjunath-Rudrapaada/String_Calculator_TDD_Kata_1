

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
	
	public int add(String inputString) {
		
		if (inputString.isEmpty()) {
			return 0;
		}
		
		if (inputString.length() == 1) {
			return Integer.parseInt(inputString);
		}
		
		String delimiter = ",|\\n";
		
		if (inputString.startsWith("//")) {
			int delimiterPatternEndIndex = inputString.indexOf("\n");
			delimiter = Pattern.quote(inputString.substring(2, delimiterPatternEndIndex));
			inputString = inputString.substring(delimiterPatternEndIndex + 1);
		}
		
		String[] nums = inputString.split(delimiter);
		
		int sum = Arrays.stream(nums)
				.filter(num -> !num.isEmpty()) // to filter empty strings
				.mapToInt(Integer::parseInt)
				.sum();
		
		return sum;
	}

}
