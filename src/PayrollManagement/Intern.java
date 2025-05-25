package PayrollManagement;

import java.util.Scanner;

public class Intern extends Employee {
    Scanner sc = new Scanner(System.in);
    public double stipend;

    public Intern() {
        super("Vanitha", 28, "Assistant");
        System.out.println("Enter stipend:");
        stipend = sc.nextDouble();
    }

    public void calculate() {
        salary = stipend;
        System.out.println("Salary of intern = " + salary);
    }
}
