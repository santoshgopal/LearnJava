package infoSec;

import java.sql.*;
import java.util.Scanner;

/**
 * hashEncryptorAndDecryptor
 */
public class hashEncryptorAndDecryptor {

    static final String driverName = "com.mysql.jdbc.Driver";
    static Scanner sc = new Scanner(System.in);
    static final String myUrl = "jdbc:mysql://localhost:3306/DATABASE_NAME";
    static final String myUsername = "USERNAME_OF_MYSQL_SERVER";
    static final String myPassword = "PASSWORD_OF_MYSQL_SERVER";
    static String hashValue;

    public static void main(String[] args) throws Exception {
        hashEncryptorAndDecryptor hashd = new hashEncryptorAndDecryptor();
        System.out.println("1. Encrypt password to hash");
        System.out.println("2. Decrypt hash to password");
        int mode = sc.nextInt();
        if (mode == 1) {
            System.out.println("Encryption type: ");
            System.out.println("1. MD5");
            System.out.println("2. SHA1");
            int choose = sc.nextInt();
            if (choose == 1) {
                hashd.storeAsMd5Hash();
                System.out.println("Hash Stored !! As MD5");
            } else if (choose == 2) {
                hashd.storeAsSha1Hash();
                System.out.println("Hash Stored !! As SHA1");
            } else {
                System.out.println(" Wrong choice !! ");
            }

        } else if (mode == 2) {

            System.out.println("Enter the hashtype: ");
            System.out.println("1. MD5");
            System.out.println("2. SHA1");
            int choice = sc.nextInt();
            if (choice == 1) {
                hashd.fetchMd5AsPassword();
                System.out.println(hashValue);
            } else if (choice == 2) {
                hashd.fetchSHA1asPassword();
                System.out.println(hashValue);
            } else {
                System.out.println("Wrong choice !!");
                System.exit(0);
            }

        } else {
            System.out.println("Wrong Choice !!");
            System.exit(0);
        }
    }

    public void storeAsMd5Hash() throws Exception {
        System.out.print("Password: ");
        String pass = sc.next();

        if (pass != null) {
            Class.forName(driverName);
            Connection co = DriverManager.getConnection(myUrl, myUsername, myPassword);
            String sql_query = "insert into md5 values(MD5(?),?)";
            PreparedStatement ps = co.prepareStatement(sql_query);
            ps.setString(1, pass);
            ps.setString(2, pass);
            int recordInserted = ps.executeUpdate();
            co.close();
            System.out.println(recordInserted + " Line Inserted");
        } else {
            System.out.println("Can not insert Empty Values");
        }
    }

    public void storeAsSha1Hash() throws Exception {
        System.out.print("Password: ");
        String pass = sc.next();

        if (pass != null) {
            Class.forName(driverName);
            Connection co = DriverManager.getConnection(myUrl, myUsername, myPassword);
            String sql_query = "insert into sha1 values(SHA1(?),?)";
            PreparedStatement ps = co.prepareStatement(sql_query);
            ps.setString(1, pass);
            ps.setString(2, pass);
            int recordInserted = ps.executeUpdate();
            co.close();
            System.out.println(recordInserted + " Line Inserted");
        } else {
            System.out.println("Can not insert Empty Values");
        }
    }

    public void fetchMd5AsPassword() throws Exception {
        // look for md5 hash in db
        System.out.print("Enter Hash: ");
        System.out.println("\n");
        String hash = sc.next();

        if (hash != null) {
            Class.forName(driverName);
            Connection co = DriverManager.getConnection(myUrl, myUsername, myPassword);
            String sql_query = "select value from md5 where hash=?";
            PreparedStatement ps = co.prepareStatement(sql_query);
            ps.setString(1, hash);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hashValue = rs.getString("value");
            }
            co.close();
        }
    }

    public void fetchSHA1asPassword() throws Exception {
        // look for sha1 hash in db
        System.out.print("Enter Hash: ");
        System.out.println("\n");
        String hash = sc.next();

        if (hash != null) {
            Class.forName(driverName);
            Connection co = DriverManager.getConnection(myUrl, myUsername, myPassword);
            String sql_query = "select value from sha1 where hash=?";
            PreparedStatement ps = co.prepareStatement(sql_query);
            ps.setString(1, hash);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hashValue = rs.getString("value");
            }
            co.close();
        }
    }
}
