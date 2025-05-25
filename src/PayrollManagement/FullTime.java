package PayrollManagement;

import java.util.Scanner;

public class FullTime extends Employee {
    Scanner sc = new Scanner(System.in);
    public double basic, hra, da;

    public FullTime() {
        super("Kavya", 30, "Programmer");
        System.out.println("Enter basic, HRA and DA pay - ");
        basic = sc.nextDouble();
        hra = sc.nextDouble();
        da = sc.nextDouble();
    }

    public void calculate() {
        salary = basic + (hra * basic) + (da * basic);
        System.out.println("Salary of full time employee = " + salary);
    }
}

