package Queues;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue:");
        int size = sc.nextInt();
        MyQueue queue = new MyQueue(size);
        while (true) {
            System.out.println("1. Push\n2. Pop\n3. Display\n4. Exit");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter element to push:");
                        int element = sc.nextInt();
                        queue.push(element);
                        break;
                    case 2:
                        System.out.println("Popped element: " + queue.pop());
                        break;
                    case 3:
                        queue.display();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (QueueOverflowError | QueueUnderflowError e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
