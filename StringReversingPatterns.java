package stringPractice;

import java.util.Scanner;

public class StringReversingPatterns {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = sc.nextLine();
		System.out.println("PRESS");
		System.out.println("1. Using String method(reverse())");
		System.out.println("2. Using itration over (charAt(index))");
		int selector = sc.nextInt();
		if (selector == 1) {
			System.out.println("Original: " + str);
			// reversing
			StringBuffer stbf = new StringBuffer(str);
			String newString = stbf.reverse().toString();
			System.out.println("Reversed: " + newString);
		} else if (selector == 2) {
			System.out.println("Original: " + str);
			System.out.print("Reversed:");
			for (int i = str.length() - 1; i >= 0; i--) {
				System.out.print(str.charAt(i));
			}
		} else {
			System.out.println("Invalid entry!!");
			System.exit(0);
		}
		sc.close();
	}
}
