package cetpa;

import java.util.Scanner;

public class NumberToWord {

	public void setOfArray(int n, String ch) {
		String[] ones = { " ", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
				" Eleven", " Twelve", " Thirteen", " Fourteen", "Fifteen", " Sixteen", " Seventeen", " Eighteen",
				" Nineteen" };
		// this array Ones is of String data type and it is created to store the index
		// wise value of one to nineteen

		String[] tens = { " ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty",
				" Ninety" };
		// this array tens is of String data type and it is created to store the tens
		// base of data starting with index value and considering as one space for ones
		// and another for tens then starting with twenty

		if (n > 19) {
			System.out.print(tens[n / 10] + " " + ones[n % 10]);
		}
		// for all the positive values greater than ones array of String data type
		else {
			System.out.print(ones[n]);
		}
		// for all the value smaller than 19 and greater than zero
		if (n > 0) {
			System.out.print(ch);
		}
		// calling the integer n for all the positive values
		// where n is used to store the scanned value by user
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		System.out.println();
		System.out.println("Input value is: " + n);
		if (n <= 0) {
			if (n == 0) {
				System.out.println("Zero");
			} else {
				System.out.println("Bro What is this??");
				System.out.println("Please Enter positive value only.");
			}
		} 
		else {
			if (n >= 100000001) {
				System.out.println("This is too much to handle.");
				System.out.println("I am sorry I can not do this for a kid like you.");
			} else {
				NumberToWord aw = new NumberToWord();
				aw.setOfArray((n / 1000000000), " Hundred");
				aw.setOfArray((n / 10000000) % 100, " Crore");
				aw.setOfArray(((n / 100000) % 100), " Lakh");
				aw.setOfArray(((n / 1000) % 100), " Thousand");
				aw.setOfArray(((n / 100) % 10), " Hundred");
				aw.setOfArray((n % 100), " ");
			}
		}
	}
}