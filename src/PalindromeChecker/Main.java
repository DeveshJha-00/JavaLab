package PalindromeChecker;

import java.util.Scanner;

public class Main {

    public static void validateInput(String str) throws InvalidInputException, ShortStringException {
        if (!str.matches("[a-zA-Z]+")){
            throw new InvalidInputException("Input must contain only alphabetic characters");
        }
        if (str.length() < 3) {
            throw new ShortStringException("Input must be at least 3 characters long");
        }
        StringBuffer org = new StringBuffer(str);
        StringBuffer rev = new StringBuffer(str).reverse();
        if (org.toString().equalsIgnoreCase(rev.toString())){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not a Palindrome");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string : ");
        String str = sc.nextLine();
        try{
            validateInput(str);
        } catch (InvalidInputException | ShortStringException e) {
            System.out.println(e.getMessage());
        }
    }

}
