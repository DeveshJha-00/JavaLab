package Application;

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
        System.out.println("Concatenated with 'Hello' : " + sp.concatenate(str, "Hello"));
        System.out.println("Vowel count : " + sp.countVowels(str));
        System.out.println("Word count : " + sp.wordCount(str));
    }
}
