package infoSec;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 * passwordGenerator
 */
public class passwordGenerator {

    private static final Random r = new SecureRandom();
    private static final String alpha = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_@$%&()#!,.?:;`~/*-+{}[]<>";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter length for password: ");
        int passLength = sc.nextInt();
        passwordGenerator pwd = new passwordGenerator();
        String password = pwd.generatePasswordNow(passLength);
        System.out.println("Secure Password: " + password);
        sc.close();
    }

    public String generatePasswordNow(int length) {

        StringBuilder stb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stb.append(alpha.charAt(passwordGenerator.r.nextInt(alpha.length()))); // still have some error here
        }
        return new String(stb);
    }
}
