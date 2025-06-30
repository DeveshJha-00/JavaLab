package Ques11JDBC;

import javax.swing.*;
import java.sql.*;

public class DisplayForm extends JFrame {

    public DisplayForm() {
        setTitle("Reps with Customers (Credit > 15000)");
        setSize(400, 500);

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        add(displayArea);

        setVisible(true);

        try (Connection con = Main.getConnection()) {
            String query = """
                SELECT DISTINCT R.RepNo, R.RepName, R.State, R.Comission, R.Rate
                FROM Representative R JOIN Customer C ON R.RepNo = C.RepNo
                WHERE C.Credit_Limit > 15000
            """;

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                displayArea.append("RepNo: " + rs.getInt("RepNo") +
                        ", Name: " + rs.getString("RepName") +
                        ", State: " + rs.getString("State") +
                        ", Commission: " + rs.getDouble("Comission") +
                        ", Rate: " + rs.getDouble("Rate") + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }
}

