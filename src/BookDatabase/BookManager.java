package BookDatabase;

import java.util.*;

public class BookManager {
    static List<Book> books = new ArrayList<>();
    static List<Book> sortedBooks = new ArrayList<>();
    static List<Book> pricedBooks= new ArrayList<>();
    static Map<Integer,Book> map = new HashMap<>();

    public void displayBooks(){
        for (Book b : books){
            System.out.println(b);
        }
        System.out.println("---------------");
    }

    public void sortBooks(){
        Collections.sort(books, new CompareBook());
        for (Book b : books){
            sortedBooks.add(b);
        }
        for(Book b : sortedBooks){
            System.out.println(b);
        }
        System.out.println("-----------");
    }

    public void addHash(){
        int i = 1;
        for (Book b : books) map.put(i++, b);
        for (Map.Entry<Integer, Book> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("-----------");
    }

    public void searchByAuthorName(String name){
        for (Book b : books){
            if (b.author.equalsIgnoreCase(name)) {
                System.out.println(b);
            }
        }
        System.out.println("-------------");
    }

    public void setPricedBooks(double p){
        for (Book b : books){
            if (b.price >= p) pricedBooks.add(b);
        }
        for (Book b : pricedBooks) System.out.println(b);
        System.out.println("-----------");
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "John Doe", "Tech Press", 29.99);
        Book b2 = new Book("Python Basics", "Jane Smith", "Code House", 19.99);
        Book b3 = new Book("Data Structures", "Alice Johnson", "Learn Hub", 39.99);
        books.add(b1); books.add(b2); books.add(b3);

        BookManager bm = new BookManager();
        System.out.println("Books are : ");
        bm.displayBooks();
        System.out.println("Sorted Books are : ");
        bm.sortBooks();
        System.out.println("Books in HashMap are : ");
        bm.addHash();

        System.out.println("Enter author name to search: ");
        Scanner sc = new Scanner(System.in);
        String author = sc.nextLine();
        bm.searchByAuthorName(author);

        System.out.println("Enter price to filter books: ");
        double price = sc.nextDouble();
        bm.setPricedBooks(price);

    }

}
