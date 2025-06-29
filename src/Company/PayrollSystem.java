package Company;

import java.util.ArrayList;
import PayrollManagement.*;

public class PayrollSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new FullTime("Alice", 30, 50000));
        employees.add(new PartTime("Bob", 22, 20, 300));
        employees.add(new Intern("Charlie", 20, 8000));

        for (Employee emp : employees) {
            emp.calculate();
        }

    }
}