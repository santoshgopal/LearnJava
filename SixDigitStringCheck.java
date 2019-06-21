package stringPractice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SixDigitStringCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an Array");
		String[] Number = new String[sc.nextInt()];

		System.out.println("Enter the number squence");
		System.out.println("e.g, 12,1231,15056,13216050431 ");
		System.out.println("Enter: \n");
		for (int i = 0; i < Number.length; i++) {
			System.out.print("Value at Index: " + i + " is :");
			Number[i] = sc.next();
		}

		System.out.println();
		Pattern digitPattern = Pattern.compile("\\d{6}");

		// 6 is passed to check how many digits are together i,e 6 (is a pattern)
		// this is how it looks
		// Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");

		for (String number : Number) {
			boolean condition = digitPattern.matcher(number).matches(); // will be true if pattern matches else false
			System.out.println("Does " + number + " is 6 digit number ? ----> " + condition);
		}
		sc.close();
	}
}