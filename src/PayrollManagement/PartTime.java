package PayrollManagement;

public class PartTime extends Employee implements Payable {
    private int hoursWorked;
    private double hourlyRate;

    public PartTime(String name, int age, int hoursWorked, double hourlyRate) {
        super(name, age, 0, "Part-Time");
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculate() {
        salary = hoursWorked * hourlyRate;
        System.out.println(name + "'s Part-Time Wages: " + salary);
    }
}
