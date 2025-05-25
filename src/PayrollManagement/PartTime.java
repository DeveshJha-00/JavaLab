package PayrollManagement;

import java.util.Scanner;

public class PartTime extends Employee {
    Scanner sc = new Scanner(System.in);
    public double wage;
    int hours;

    public PartTime() {
        super("Kapil", 24, "Team lead");
        System.out.println("Enter hours & wage:");
        hours = sc.nextInt();
        wage = sc.nextDouble();
    }

    public void calculate() {
        salary = hours * wage;
        System.out.println("Salary of part time emp = " + salary);
    }
}
