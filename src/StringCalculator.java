

import java.util.Arrays;

public class StringCalculator {
	
	public int add(String inputString) {
		
		if (inputString.isEmpty()) {
			return 0;
		}
		
		if (inputString.length() == 1) {
			return Integer.parseInt(inputString);
		}
		
		String[] nums = inputString.split(",|\\n");
		
		int sum = Arrays.stream(nums).mapToInt(Integer::parseInt).sum();
		
		return sum;
	}

}
