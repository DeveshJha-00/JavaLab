/*
Create a desktop Java application using Swing to simulate a shopping interface:
- Validate login credentials.
- Allow customer lookup and item selection.
- Apply discount and print purchase summary.
*/

package Ques10SwingShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame implements ActionListener {

    Map<String, Customer> users = new HashMap<>();      //mobile to customer map
    Map<String, Item> items = new HashMap<>();          //itemId to Item map

    JTextField mobileField, itemIdField, quantityField;
    JLabel itemNameLabel, totalCostLabel;
    JButton fetchBtn, discountBtn, printBtn;

    Customer currentCustomer = null;
    Item currentItem = null;
    double totalCost = 0;

    public Main() {
        // Login validation
        String user = JOptionPane.showInputDialog(null, "Enter username:");
        String pass = JOptionPane.showInputDialog(null, "Enter password:");

        if (!"admin".equals(user) || !"1234".equals(pass)) {
            JOptionPane.showMessageDialog(null, "Invalid credentials! Exiting.");
            System.exit(0);
        }

        // Sample customer and item database
        users.put("1234567890", new Customer("C101", "1234567890"));
        items.put("I001", new Item("I001", "Laptop", 50000));
        items.put("I002", new Item("I002", "Smartphone", 25000));
        items.put("I003", new Item("I003", "Headphones", 2000));

        // Frame setup
        setTitle("Customer Purchase System");
        setSize(350, 500);
        setLayout(new GridLayout(7, 2));
//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mobileField = new JTextField();
        itemIdField = new JTextField();
        quantityField = new JTextField();
        // Adding components
        add(new JLabel("Enter Mobile Number:"));     add(mobileField);
        add(new JLabel("Enter Item ID:"));           add(itemIdField);
        add(new JLabel("Enter Quantity:"));          add(quantityField);

        add(new JLabel("Item Name:"));
        itemNameLabel = new JLabel("-");    add(itemNameLabel);
        add(new JLabel("Total Cost:"));
        totalCostLabel = new JLabel("-");   add(totalCostLabel);

        fetchBtn = new JButton("Fetch & Compute");
        discountBtn = new JButton("Apply Discount");
        printBtn = new JButton("Print");
        add(fetchBtn); add(discountBtn); add(printBtn);

        fetchBtn.addActionListener(this);
        discountBtn.addActionListener(this);
        printBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fetchBtn) {
            String mobile = mobileField.getText();
            String itemId = itemIdField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
//            int quantity;
            //VALIDATION OF INPUTS
//            if (mobile.isEmpty() || itemId.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please fill all fields.");
//                return;
//            }
//            try {
//                quantity = Integer.parseInt(quantityField.getText());
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, "Enter a valid quantity.");
//                return;
//            }

            // Check if customer exists or create new
            if (users.containsKey(mobile)) {
                JOptionPane.showMessageDialog(this, "Welcome " + users.get(mobile).id+" !");
                currentCustomer = users.get(mobile);
            } else {
                String custId = JOptionPane.showInputDialog(this, "New customer! Enter Customer ID:");
                currentCustomer = new Customer(custId, mobile);
                users.put(mobile, currentCustomer);
            }

//             Validate item exists
            if (!items.containsKey(itemId)) {
                JOptionPane.showMessageDialog(this, "Invalid Item ID.");
                return;
            }

            currentItem = items.get(itemId);
            totalCost = currentItem.price * quantity;

            itemNameLabel.setText(currentItem.itemName);
            totalCostLabel.setText("Rs. " + totalCost);
        }

        else if (e.getSource() == discountBtn) {
            String[] options = {"5", "10", "20"};
            int choice = JOptionPane.showOptionDialog(
                    this,
                    "Select Discount Type:",
                    "Discount Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            totalCost = totalCost - (totalCost * 0.01 * Integer.parseInt(options[choice]));
            totalCostLabel.setText("Rs. " + totalCost);
        }

        else if (e.getSource() == printBtn) {
            String msg = "Customer ID: " + currentCustomer.id + "\n" +
                    "Mobile: " + currentCustomer.mobile + "\n" +
                    "Item: " + currentItem.itemName + "\n" +
                    "Total Cost (after discount): Rs. " + (totalCost);

            JOptionPane.showMessageDialog(this, msg, "Purchase Summary", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
