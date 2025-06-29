package PayrollManagement;

public class FullTime extends Employee implements Payable {
    public FullTime(String name, int age, double monthlySalary) {
        super(name, age, monthlySalary, "Full-Time");
    }

    @Override
    public void calculate() {
        // Salary is already fixed monthly
        System.out.println(name + "'s Full-Time Monthly Salary: " + salary);
    }
}
