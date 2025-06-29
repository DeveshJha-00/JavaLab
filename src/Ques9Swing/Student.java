package Ques9Swing;

public class Student {
    String name, usn, address, category;
    int age;
    double cgpa;

    public Student(String name, String usn, int age, String address, String category, double cgpa) {
        this.name = name;
        this.usn = usn;
        this.address = address;
        this.category = category;
        this.age = age;
        this.cgpa=cgpa;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", usn='" + usn + '\'' +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", age=" + age +
                ", cgpa=" + cgpa +
                '}';
    }
}

