package stringPractice;

import java.util.Scanner;

public class StingContainsDigitsCheckup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("First String");
		String a = sc.next();
		System.out.println("Second String");
		String b = sc.next();
		String str = a.concat(b);

		if ((str != null) && (!str.isEmpty())) {
			for (char c : str.toCharArray()) {
				if (Character.isDigit(c)) {
					System.out.println("Contains Digits");
					break;
				}
			}
		}
		sc.close();
	}
}