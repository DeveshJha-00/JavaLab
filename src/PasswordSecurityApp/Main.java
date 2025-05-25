package PasswordSecurityApp;

import java.util.Scanner;

public class Main {

    public static void isSafe(String pwd){
        boolean hasUpper=false, hasLower=false, hasDigit=false;
        int spec=0;
        for (char ch : pwd.toCharArray()){
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else spec++;
        }
        System.out.println("Contains uppercase letters: " + hasUpper);
        System.out.println("Contains lowercase letters: " + hasLower);
        System.out.println("Contains digits: " + hasDigit);
        System.out.println("Special characters: " + spec);
    }

    public static String maskPwd(String pwd){
        if (pwd.length()<=2) return pwd;
        StringBuilder masked = new StringBuilder();
        masked.append(pwd.charAt(0));
//        for (int i = 1; i < pwd.length() - 1; i++) {
//            masked.append('*');
//        }
        masked.append("*".repeat(pwd.length() - 2));
        masked.append(pwd.charAt(pwd.length() - 1));
        return masked.toString();
    }

    public static String revs(String pwd){
        StringBuilder reversed = new StringBuilder(pwd);
        return reversed.reverse().toString();
    }

    public static String randToken(String pwd){
        int num = (int)(Math.random()*1000);
        String token=String.valueOf("@"+num+"!");
        return pwd+token;
    }

    public static String replaceVowels(String str){
        StringBuilder masked = new StringBuilder();
        for(char ch : str.toCharArray()){
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                masked.append('*');
            } else {
                masked.append(ch);
            }
        }
        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password: ");
        String pwd = sc.nextLine();
        isSafe(pwd);
        System.out.println("Masked password: " + maskPwd(pwd));
        System.out.println("Reversed password: " + revs(pwd));
        System.out.println("Password with random token: " + randToken(pwd));
        System.out.println("Password with vowels replaced: " + replaceVowels(pwd));
    }

}
