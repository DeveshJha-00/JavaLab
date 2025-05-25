package Queues;

public class MyQueue {
    int size,front,rear;
    int[] arr;
    public MyQueue(int n) {
        this.front=0;
        this.rear=-1;
        this.size=n;
        arr = new int[n];
    }
    public void push(int ele) throws QueueOverflowError {
        if (rear == size - 1) {
            throw new QueueOverflowError("Queue is full");
        }
        arr[++rear] = front;
    }
    public int pop() throws QueueUnderflowError{
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
