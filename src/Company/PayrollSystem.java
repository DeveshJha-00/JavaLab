package Company;

import PayrollManagement.*;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] emps = new Employee[3];
        emps[0] = new FullTime();
        emps[1] = new PartTime();
        emps[2] = new Intern();

        for (Employee e : emps) {
            e.calculate();
        }

    }
}
