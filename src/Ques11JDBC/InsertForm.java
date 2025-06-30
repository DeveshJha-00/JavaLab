package Ques11JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InsertForm extends JFrame implements ActionListener {
    JTextField repNo, repName, repState, repComm, repRate;
    JTextField custNo, custName, custState, creditLimit, custRepNo;
    JButton insertBtn, showBtn;

    public InsertForm() {
        setTitle("Insert Representative and Customer Details");
        setSize(350, 500);
        setLayout(new GridLayout(14, 2));
//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        repNo = new JTextField();       repName = new JTextField();
        repState = new JTextField();    repComm = new JTextField();
        repRate = new JTextField();     custNo = new JTextField();
        custName = new JTextField();    custState = new JTextField();
        creditLimit = new JTextField(); custRepNo = new JTextField();
        insertBtn = new JButton("Insert");
        showBtn = new JButton("Show Reps (Credit > 15000)");

        // Rep fields
        add(new JLabel("Rep No:"));           add(repNo);
        add(new JLabel("Rep Name:"));         add(repName);
        add(new JLabel("Rep State:"));        add(repState);
        add(new JLabel("Commission:"));       add(repComm);
        add(new JLabel("Rate:"));             add(repRate);

        // Customer fields
        add(new JLabel("Customer No:"));      add(custNo);
        add(new JLabel("Customer Name:"));    add(custName);
        add(new JLabel("Customer State:"));   add(custState);
        add(new JLabel("Credit Limit:"));     add(creditLimit);
        add(new JLabel("Rep No (FK):"));      add(custRepNo);

        add(insertBtn); add(showBtn);

        insertBtn.addActionListener(this);
        showBtn.addActionListener(e -> new DisplayForm());

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try (Connection con = Main.getConnection()) {
            String query1 = "INSERT INTO Representative VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setInt(1, Integer.parseInt(repNo.getText()));
            ps1.setString(2, repName.getText());
            ps1.setString(3, repState.getText());
            ps1.setDouble(4, Double.parseDouble(repComm.getText()));
            ps1.setDouble(5, Double.parseDouble(repRate.getText()));
            ps1.executeUpdate();

            String query2 = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setInt(1, Integer.parseInt(custNo.getText()));
            ps2.setString(2, custName.getText());
            ps2.setString(3, custState.getText());
            ps2.setDouble(4, Double.parseDouble(creditLimit.getText()));
            ps2.setInt(5, Integer.parseInt(custRepNo.getText()));
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(this, "Inserted successfully!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }

    }

}
