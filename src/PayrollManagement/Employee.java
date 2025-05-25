package PayrollManagement;

public class Employee implements Payable {
    String name, designation;
    int age;
    double salary;

    public Employee(String a, int b, String c) {
        name = a;
        age = b;
        designation = c;
    }

    public void calculate() {
        salary = 0;
    }

}



