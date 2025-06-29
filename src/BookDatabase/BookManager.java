package BookDatabase;

import java.util.*;

public class BookManager {
    public static List<Book> books = new ArrayList<>();
    public static List<Book> sortedBooks = new ArrayList<>();
    public static Map<Integer,Book> map = new HashMap<>();
    public static List<Book> pricedBooks= new ArrayList<>();


    public static void sortBooks(){
        Collections.sort(books, new BookComparator());
        sortedBooks.addAll(books);
        System.out.println(sortedBooks);
    }

    public static void addHash(){
        int id = 1;
        for (Book b : books) map.put(id++, b);
        for (Map.Entry<Integer, Book> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void searchByAuthorName(String name){
        for (Book b : books){
            if (b.author.equalsIgnoreCase(name)) System.out.println(b);
        }
    }

    public static void setPricedBooks(double p){
        for (Book b : books){
            if (b.price >= p) pricedBooks.add(b);
        }
        System.out.println(pricedBooks);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book("Java Programming", "John Doe", "Tech Press", 29.99);
        Book b2 = new Book("Python Basics", "Jane Smith", "Code House", 19.99);
        Book b3 = new Book("Data Structures", "Alice Johnson", "Learn Hub", 39.99);
        books.add(b1); books.add(b2); books.add(b3);

        System.out.println("Books are : ");
        System.out.println(books);
        System.out.println("Sorted Books are : ");
        sortBooks();
        System.out.println("Books in HashMap are : ");
        addHash();

        System.out.println("Enter author name to search: ");
        String author = sc.nextLine();
        searchByAuthorName(author);

        System.out.println("Enter price to filter books: ");
        double price = sc.nextDouble();
        setPricedBooks(price);

    }

}
