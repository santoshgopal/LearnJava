package cetpa;

import java.util.Scanner;

public class ManualStringOperato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st value: ");
		String str01 = sc.next();
		float f1 = Float.parseFloat(str01);

		System.out.println("Enter 2nd value: ");
		String str02 = sc.next();
		float f2 = Float.parseFloat(str02);

		System.out.println("Enter your choice");
		String choice = sc.next();

		System.out.println("Your choice is, " + choice);

//		Command operator string starts
		String add = "add";
		String addition = "addition";
		String plus = "+";
		String subs = "subs";
		String substraction = "substraction";
		String minus = "-";
		String multi = "multi";
		String multiplication = "multiplication";
		String star = "*";
		String div = "div";
		String division = "division";
		String divis = "/";
//		Command operator string ends............

		if (choice.equalsIgnoreCase(add) || choice.equalsIgnoreCase(addition) || choice.equalsIgnoreCase(plus)) {
			float result = f1 + f2;
			System.out.println("Result is : " + result);
		}

		else if (choice.equalsIgnoreCase(subs) || choice.equalsIgnoreCase(substraction)
				|| choice.equalsIgnoreCase(minus)) {
			float result = f1 - f2;
			System.out.println("Result is : " + result);
		}

		else if (choice.equalsIgnoreCase(multi) || choice.equalsIgnoreCase(multiplication)
				|| choice.equalsIgnoreCase(star)) {
			float result = f1 * f2;
			System.out.println("Result is : " + result);
		}

		else if (choice.equalsIgnoreCase(div) || choice.equalsIgnoreCase(division) || choice.equalsIgnoreCase(divis)) {
			float result = f1 / f2;
			System.out.println("Result is : " + result);
		} else {
			System.out.println("Invalid Selection !!");
		}
	}
}