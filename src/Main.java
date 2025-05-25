/*
Create a desktop java application using swings to enable a user to enter student information such as name, usn, age, address, sgpa of 4 semesters, category.
(a). Perform validations on all the fields. Display appropriate messages in pop-up boxes to indicate wrong entries.
(b). On clicking of the “compute” button, find the cgpa (Average of sgpas).
     On clicking of the “done” button, place the student details ( name, usn, age, address,cgpa, category) in a collection.
(c). Display the collection in a textarea on the click of a “complete” button. Enable / Disable the visibility of “compute” and “done” buttons.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Student {
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




public class Main implements ActionListener {

    ArrayList<Student> list = new ArrayList<>();
    static JFrame frame1, frame2;
    JLabel name1, usn1, age1, address1, category1, details, sgpa1, sgpa2, sgpa3, sgpa4, cgpa1;
    JTextField name, usn, address, age, sgpa, category, gpa1, gpa2, gpa3, gpa4, cgpa;
    JButton compute, done, complete;
    JTextArea textArea;

    double totalCGPA;

    public Main(){
        frame1 = new JFrame("Enter details");
        frame2 = new JFrame("Displaying details");

        name1 = new JLabel("Enter name - ");
        age1 = new JLabel("Enter age - ");
        address1 = new JLabel("Enter address - ");
        usn1 = new JLabel("Enter usn - ");
        category1= new JLabel("Enter category - ");
        sgpa1 = new JLabel("Enter SGPA 1 - ");
        sgpa2 = new JLabel("Enter SGPA 2 - ");
        sgpa3 = new JLabel("Enter SGPA 3 - ");
        sgpa4 = new JLabel("Enter SGPA 4 - ");
        cgpa1 = new JLabel("CGPA computed - ");
        details = new JLabel("Collection of students"); //no corresponding textfield needed as no i/p required for this

        name = new JTextField(20);
        age = new JTextField(20);
        address = new JTextField(20);
        usn = new JTextField(20);
        category = new JTextField(20);
        gpa1 = new JTextField(10);
        gpa2 = new JTextField(10);
        gpa3 = new JTextField(10);
        gpa4 = new JTextField(10);
        cgpa = new JTextField(10);
        textArea = new JTextArea(100,100); //to display the collection

        compute = new JButton("COMPUTE CGPA");
        done = new JButton("ADD TO COLLECTION");
        complete= new JButton("PLACE IN TEXTAREA");

        //adding labels and corresponding textfields
        frame1.add(name1);      frame1.add(name);
        frame1.add(age1);       frame1.add(age);
        frame1.add(address1);   frame1.add(address);
        frame1.add(usn1);       frame1.add(usn);
        frame1.add(category1);  frame1.add(category);
        frame1.add(sgpa1);      frame1.add(gpa1);
        frame1.add(sgpa2);      frame1.add(gpa2);
        frame1.add(sgpa3);      frame1.add(gpa3);
        frame1.add(sgpa4);      frame1.add(gpa4);
        frame1.add(cgpa1);      frame1.add(cgpa);

        frame2.add(details);

        frame2.add(textArea);

        frame1.add(complete);
        frame1.add(compute);
        frame1.add(done);

        compute.addActionListener(this);
        complete.addActionListener(this);
        done.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==compute){
            double g1 = Double.parseDouble(gpa1.getText()); //textfield.getText()
            double g2 = Double.parseDouble(gpa2.getText());
            double g3 = Double.parseDouble(gpa3.getText());
            double g4 = Double.parseDouble(gpa4.getText());
            if (g1>10 || g2>10 || g3>10 || g4 >10){
                JOptionPane.showMessageDialog(null, "Enter correct SGPA values.");
            }else {
                totalCGPA = (g1 + g2 + g3 + g4) / 4;
                cgpa.setText("CGPA is : " + totalCGPA);         //textfield.setText()
            }
            done.setVisible(true); complete.setVisible(true);
        }
        else if (e.getSource() == done){
            String n = name.getText();
            String a = address.getText();
            String u = usn.getText();
            String c = category.getText();
            double g1 = Double.parseDouble(gpa1.getText());
            double g2 = Double.parseDouble(gpa2.getText());
            double g3 = Double.parseDouble(gpa3.getText());
            double g4 = Double.parseDouble(gpa4.getText());
            int x = Integer.parseInt(age.getText());
            if (x<18){
                JOptionPane.showMessageDialog(null,"Enter correct age - ");
            }else{
                Student s = new Student(n,u,a,c,x,g1,g2,g3,g4);
                list.add(s);
            }
        }
        else if (e.getSource()==complete){
            textArea.setText("");
            for (Student stud : list){
                textArea.append(stud + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        frame1.setVisible(true);
        frame1.setSize(300,400);
        frame1.setLayout(new GridLayout(13,1));
        frame2.setVisible(true);
        frame2.setSize(300,400);
        frame2.setLayout(new GridLayout(9,1));
    }


}