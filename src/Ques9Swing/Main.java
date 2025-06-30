/*
Create a desktop java application using swings to enable a user to enter student
information such as name, usn, age, address, sgpa of 4 semesters, category(as combobox).
a. Perform validations on all the fields. Display appropriate messages in pop up boxes to
indicate wrong entries.
b. On clicking of the “compute” button, find the cgpa (Average of sgpas) . On clicking of the
“done” button, place the student details(name, usn, age, address,cgpa,category) in a collection.
c. Display the collection in a textarea on the click of a “complete” button.
Enable / Disable the visibility of “compute” and “done” buttons.
 */

package Ques9Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main implements ActionListener {

    ArrayList<Student> list = new ArrayList<>();
    static JFrame frame1, frame2;
    JTextField name, usn, age, address, gpa1, gpa2, gpa3, gpa4, cgpa;
    JComboBox<String> category;
    JTextArea detailsArea;
    JButton compute, done, complete;
    double totalCGPA = 0;

    public Main() {
        frame1 = new JFrame("Enter details");
        frame2 = new JFrame("Displaying details");

        name = new JTextField();    usn = new JTextField();
        age = new JTextField();     address = new JTextField();
        String[] options = new String[]{"GM", "SC", "ST", "OBC", "Others"};
        category = new JComboBox<>(options);
        gpa1 = new JTextField();    gpa2 = new JTextField();
        gpa3 = new JTextField();    gpa4 = new JTextField();
        cgpa = new JTextField();
        cgpa.setEditable(false);
        detailsArea = new JTextArea(); //to display the collection
        compute = new JButton("COMPUTE");
        done = new JButton("DONE");
        complete = new JButton("COMPLETE");

        // Adding labels and corresponding fields
        frame1.add(new JLabel("Enter name - "));        frame1.add(name);
        frame1.add(new JLabel("Enter usn - "));         frame1.add(usn);
        frame1.add(new JLabel("Enter age - "));         frame1.add(age);
        frame1.add(new JLabel("Enter address - "));     frame1.add(address);
        frame1.add(new JLabel("Enter category - "));    frame1.add(category);
        frame1.add(new JLabel("Enter SGPA1 - "));       frame1.add(gpa1);
        frame1.add(new JLabel("Enter SGPA2 - "));       frame1.add(gpa2);
        frame1.add(new JLabel("Enter SGPA3 - "));       frame1.add(gpa3);
        frame1.add(new JLabel("Enter SGPA4 - "));       frame1.add(gpa4);
        frame1.add(new JLabel("CGPA computed - "));     frame1.add(cgpa);

        frame1.add(compute); frame1.add(done);
        frame1.add(complete);
        done.setVisible(false);

        frame2.add(detailsArea);

        compute.addActionListener(this);
        complete.addActionListener(this);
        done.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        double g1, g2, g3, g4;
        try {
            g1 = Double.parseDouble(gpa1.getText());
            g2 = Double.parseDouble(gpa2.getText());
            g3 = Double.parseDouble(gpa3.getText());
            g4 = Double.parseDouble(gpa4.getText());
            if (g1 > 10 || g2 > 10 || g3 > 10 || g4 > 10) {
                JOptionPane.showMessageDialog(null, "Enter SGPA values less than or equal to 10.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "SGPA cant be empty or non-numeric.");
            return;
        }

        if (e.getSource() == compute) {
            totalCGPA = (g1 + g2 + g3 + g4) / 4;
            cgpa.setText("CGPA is : " + totalCGPA);
            done.setVisible(true);
            compute.setVisible(false);
        }

        else if (e.getSource() == done) {
            String n = name.getText();
            String u = usn.getText();
            String a = address.getText();
            String c = (String) category.getSelectedItem();
            if (n.isEmpty() || u.isEmpty() || a.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields.");
            }
            int x = Integer.parseInt(age.getText());
            if (x < 15) {
                JOptionPane.showMessageDialog(null, "Enter correct age (must be 15 or older).");
            } else {
                Student s = new Student(n, u, x, a, c, totalCGPA);
                list.add(s);
                JOptionPane.showMessageDialog(null, "Student record added.");
            }
            done.setVisible(false);
            compute.setVisible(true);
        }

        else if (e.getSource() == complete) {
            detailsArea.setText("");
            for (Student s : list) {
                detailsArea.append(s + "\n");
            }
        }

    }

    public static void main(String[] args) {
        new Main();
        frame1.setTitle("Student Information Form");
        frame1.setSize(350, 500);
        frame1.setLayout(new GridLayout(14, 2));
        frame1.setVisible(true);
        frame2.setTitle("Student Details");
        frame2.setSize(350, 500);
        frame2.setVisible(true);
    }
}
