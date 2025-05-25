package StringOpMain;

import StringOperations.StringProcessor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringProcessor sp = new StringProcessor();
        System.out.println("Enter string : ");
        String str = sc.nextLine();
        System.out.println("Reversed : " + sp.reverse(str));
        System.out.println("Uppercase : " + sp.toUpperCase(str));
        System.out.println("Lowercase : " + sp.toLowerCase(str));
        System.out.println("Concatenated with 'Hello' : " + sp.concati(str, "Hello"));
        System.out.println("Vowel count : " + sp.countVowels(str));
        System.out.println("Word count : " + sp.wordCount(str));
        System.out.println("Is palindrome? : " + sp.isPalin(str));
    }
}
