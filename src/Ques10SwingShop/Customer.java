package Ques10SwingShop;

public class Customer {
    String id, mobile;

    Customer(String id, String mobile) {
        this.id = id;
        this.mobile = mobile;
    }

    public String toString() {
        return "Customer ID: " + id + ", Mobile: " + mobile;
    }
}
