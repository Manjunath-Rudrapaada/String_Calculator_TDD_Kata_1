

import java.util.Arrays;
import java.util.Scanner;

public class StringCalculator {
	
	public int add(String inputString) {
		
		if (inputString.isEmpty()) {
			return 0;
		}
		
		if (inputString.length() == 1) {
			return Integer.parseInt(inputString);
		}
		
		String[] nums = inputString.split(",");
		
		int sum = Arrays.stream(nums).mapToInt(Integer::parseInt).sum();
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string:");
		String inputString = sc.nextLine();
		
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add(inputString);
		System.out.println("The sum of given numbers in a string = " + sum);
		
		sc.close();
	}

}
