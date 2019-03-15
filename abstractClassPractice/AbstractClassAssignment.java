package abstractClass;

import java.util.Scanner;

public class AbstractClassAssignment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please select: ");
		System.out.println("Press 1 for Dos");
		System.out.println("Press 2 for Windows");
		System.out.println("Press 3 for MAC");
		System.out.println("Press 4 for Linx");
		System.out.println("Press 5 for Exit");

		int i = sc.nextInt();
		if (i == 1) {
			OS os_dos = new Dos(); // Using Polymorphic Assignment, created an object to call the body of that
			os_dos.objectives();
			os_dos.ui();
			os_dos.types();
			os_dos.purpose();
		}
		if (i == 2) {
			OS os_win = new Windows(); // Using Polymorphic Assignment, created an object to call the body of that
			os_win.objectives();
			os_win.ui();
			os_win.types();
			os_win.purpose();
		}
		if (i == 3) {
			OS os_mac = new Mac(); // Using Polymorphic Assignment, created an object to call the body of that method
			os_mac.objectives();
			os_mac.ui();
			os_mac.types();
			os_mac.purpose();
		}
		if (i == 4) {
			OS os_linux = new Linux(); // Using Polymorphic Assignment, created an object to call the body of that method
			os_linux.objectives();
			os_linux.ui();
			os_linux.types();
			os_linux.purpose();
		}
		if (i == 5) {
			System.out.println("Exit....");
			System.exit(0);
		} else {
			System.out.println("Invalid Selection !!");
			System.exit(0);
		}
	}
}