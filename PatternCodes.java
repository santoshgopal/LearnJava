package liveProjects.liveProjects;

import java.util.Scanner;

/**
 * PatternCodes
 */
public class PatternCodes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press");
        System.out.println("1. Pyramid");
        System.out.println("2. Invert Pyramid");
        System.out.println("3. Floyd's Triangle");
        System.out.println("4. Half-pyramid using alphabets");
        System.out.println("5. Hollow Pyramid");
        System.out.println("6. Inverted Hollow Pyramid");
        System.out.println("7. Hollow Diamond");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        switch (choice) {
        case 1:
            System.out.println("How many rows u want ?");
            int k = 0, rows = sc.nextInt();
            System.out.println("Pyramid coming up: ");
            for (int i = 1; i <= rows; i++, k = 0) {
                for (int space = 0; space <= rows - i; space++) {
                    System.out.print("  ");
                }
                while (k != 2 * i - 1) {
                    System.out.print("* ");
                    k++;
                }
                System.out.println();
            }
            break;

        case 2:
            System.out.println("How many rows u want ?");
            rows = sc.nextInt();
            for (int i = rows; i >= 1; i--) {
                for (int space = 1; space <= rows - i; space++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("* ");
                }
                for (int j = 0; j < i - 1; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }

            break;
        case 3:
            System.out.println("How many rows u want ?");
            rows = sc.nextInt();
            int number = 1;
            System.out.println("Tringle coming up: ");
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(number + " ");
                    number++;
                }
                System.out.println();
            }

            break;
        case 4:
            System.out.println("Last char is hardcoded as E !!");
            char last = 'E';
            char alphabet = 'A';
            for (int i = 1; i <= (last - 'A' + 1); i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(alphabet + " ");
                }
                ++alphabet;
                System.out.println();
            }
            break;
        case 5:
            System.out.println("How many rows u want ?");
            int n = sc.nextInt();
            int i, j, xx = 0;
            for (i = 1; i <= n; i++) {
                // Print spaces
                for (j = i; j < n; j++) {
                    System.out.print(" ");
                }
                // Print #
                while (xx != (2 * i - 1)) {
                    if (xx == 0 || xx == 2 * i - 2)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                    xx++;
                    ;
                }
                xx = 0;
                // print next row
                System.out.println();
            }
            // print last row
            for (i = 0; i < 2 * n - 1; i++) {
                System.out.print("*");
            }
            break;
        case 6:
            System.out.println("Rows ?");
            n = sc.nextInt();
            i = 0;
            j = 0;
            for (i = 1; i <= n; i++) {
                // Print spaces
                for (j = 1; j < i; j++) {
                    System.out.print(" ");
                }
                // Print hollow inverted pyramid
                for (j = 1; j <= (n * 2 - (2 * i - 1)); j++) {

                    if (i == 1 || j == 1 || j == (n * 2 - (2 * i - 1))) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                // next line
                System.out.println();
            }
            break;

        case 7:
            System.out.println("Rows?");
            n = sc.nextInt();
            i = 0;
            j = 0;
            xx = 0;
            for (i = 1; i <= n; i++) {
                // Print spaces
                for (j = i; j < n; j++) {
                    System.out.print(" ");
                }
                // Print #
                while (xx != (2 * i - 1)) {
                    if (xx == 0 || xx == 2 * i - 2)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                    xx++;
                    ;
                }
                xx = 0;
                // print next row
                System.out.println();
            }
            // print last row
            for (i = 0; i < 2 * n - 1; i++) {
                System.out.print("*");
            }

            // a new line as the same last line
            System.out.println();

            // reset the values to zero
            i = 0;
            j = 0;
            for (i = 1; i <= n; i++) {
                // Print spaces
                for (j = 1; j < i; j++) {
                    System.out.print(" ");
                }
                // Print hollow inverted pyramid
                for (j = 1; j <= (n * 2 - (2 * i - 1)); j++) {

                    if (i == 1 || j == 1 || j == (n * 2 - (2 * i - 1))) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                // next line
                System.out.println();
            }
            break;

        default:
            System.out.println("Invalid entry !!");
            System.exit(0);
            break;
        }
    }
}