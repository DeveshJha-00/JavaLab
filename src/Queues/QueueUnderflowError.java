package Queues;

public class QueueUnderflowError extends Exception {
    public QueueUnderflowError(String message) {
        super(message);
    }
}
