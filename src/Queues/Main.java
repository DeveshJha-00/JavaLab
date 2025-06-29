package Queues;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the queue:");
        int size = sc.nextInt();
        sc.nextLine();

        MyQueue queue = new MyQueue(size);

        while (true) {
            System.out.println("1. Push\n2. Pop\n3. Display\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter element to push:");
                        String name = sc.nextLine();
                        queue.enqueue(name);
                        break;
                    case 2:
                        System.out.println("Popped : " + queue.dequeue());
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
