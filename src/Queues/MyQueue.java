package Queues;

public class MyQueue {
    int size,front,rear;
    String[] arr;

    public MyQueue(int n) {
        this.front=0;
        this.rear=-1;
        this.size=n;
        arr = new String[n];
    }

    public void enqueue(String name) throws QueueOverflowError {
        if (rear == size - 1) {
            throw new QueueOverflowError("Queue is full");
        }
        arr[++rear] = name;
    }

    public String dequeue() throws QueueUnderflowError{
        if (front>rear){
            throw new QueueUnderflowError("Queue is empty");
        }
        return arr[front++];
    }

    public void display() throws QueueUnderflowError {
        if (front > rear) {
            throw new QueueUnderflowError("Queue is empty");
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
