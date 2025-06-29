package Ques11JDBC;

import java.sql.*;

public class Main {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/javalab";
            String username = "root";
            String password = "rootPassword";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        new InsertForm();
    }

}

/*
CREATE TABLE Representative (
    RepNo INT PRIMARY KEY,
    RepName VARCHAR(50),
    State VARCHAR(20),
    Comission DOUBLE,
    Rate DOUBLE
);

CREATE TABLE Customer (
    CustNo INT PRIMARY KEY,
    CustName VARCHAR(50),
    State VARCHAR(20),
    Credit_Limit DOUBLE,
    RepNo INT,
    FOREIGN KEY (RepNo) REFERENCES Representative(RepNo)
);
 */