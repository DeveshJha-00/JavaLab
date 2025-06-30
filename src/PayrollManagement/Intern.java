package PayrollManagement;

public class Intern extends Employee  {
    public Intern(String name, int age, double stipend) {
        super(name, age, stipend, "Intern");
    }

    @Override
    public void calculate() {
        // Fixed stipend
        System.out.println(name + "'s Intern Stipend: " + salary);
    }
}
