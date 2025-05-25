package Ques9Swing;

public class Student {
    String name, usn, address, category;
    int age;
    double gpa1, gpa2, gpa3, gpa4;

    public Student(String name, String usn, String address, String category, int age, double gpa1, double gpa2, double gpa3, double gpa4) {
        this.name = name;
        this.usn = usn;
        this.address = address;
        this.category = category;
        this.age = age;
        this.gpa1 = gpa1;
        this.gpa2 = gpa2;
        this.gpa3 = gpa3;
        this.gpa4 = gpa4;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", usn='" + usn + '\'' +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", age=" + age +
                ", gpa1=" + gpa1 +
                ", gpa2=" + gpa2 +
                ", gpa3=" + gpa3 +
                ", gpa4=" + gpa4 +
                '}';
    }
}
