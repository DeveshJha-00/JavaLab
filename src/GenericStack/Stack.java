package GenericStack;

public class Stack<T> {
    public int size, top;
    public T[] arr;

    public Stack(int size){
        this.size = size;
        arr = (T[]) new Object[size];
        top=-1;
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public void clear(){
        top=-1;
    }

    public void push (T ele){
        if (top==size-1) System.out.println("Stack is full");
        else arr[++top] = ele;
    }

    public T pop(){
        if (isEmpty()){
            System.out.println("Empty stack");
            return null;
        }
        return arr[top--];
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Empty stack");
        }else{
            System.out.println("Stack elements - ");
            for (int i=top; i>=0; i--){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack of integers - ");
        Stack<Integer> intSt = new Stack<>(3);
        intSt.push(10);
        intSt.push(20);
        intSt.push(30);
        intSt.display();
        intSt.pop();
        intSt.display();
        intSt.clear();
        intSt.display();

        System.out.println("-----------------------------");
        System.out.println("Stack of strings - ");
        Stack<String> strSt = new Stack<>(3);
        strSt.push("Java");
        strSt.push("World");
        strSt.push("Hello");
        strSt.display();
        strSt.pop();
        strSt.display();
        strSt.clear();
        strSt.display();

    }

}
