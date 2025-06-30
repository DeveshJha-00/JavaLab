package PalindromeChecker;

import java.util.Scanner;

public class Main {

    public static void validateInput(String str) throws InvalidInputException, LongStringException {
        if (!str.matches("[a-zA-Z]+")){
            throw new InvalidInputException("Input must contain only alphabetic characters");
        }
        if (str.length() > 5) {
            throw new LongStringException("Input is more than 5 characters long");
        }

        StringBuffer org = new StringBuffer(str);
        if (org.toString().equalsIgnoreCase(org.reverse().toString())){
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
        } catch (InvalidInputException | LongStringException e) {
            System.out.println(e.getMessage());
        }

    }

}
