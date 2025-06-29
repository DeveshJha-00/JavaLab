package PayrollManagement;

public abstract class Employee implements Payable {
     String name;
     int age;
     double salary;
     String designation;

    public Employee(String name, int age, double salary, String designation) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }

}
