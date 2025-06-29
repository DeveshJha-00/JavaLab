package GenericStack;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void push(T ele) {
        list.add(ele);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Empty stack");
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty stack");
        } else {
            System.out.println("Stack elements - ");
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack of Strings:");
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Java");
        stringStack.push("World");
        stringStack.push("Hello");
        stringStack.display();
        stringStack.pop();
        stringStack.display();
        stringStack.clear();
        stringStack.display();

        System.out.println("-----------------------------");

        System.out.println("Stack of Floats:");
        Stack<Float> floatStack = new Stack<>();
        floatStack.push(3.14f);
        floatStack.push(9.81f);
        floatStack.push(1.618f);
        floatStack.display();
        floatStack.pop();
        floatStack.display();
        floatStack.clear();
        floatStack.display();
    }
}
