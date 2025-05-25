package BookDatabase;

import java.util.Comparator;

public class CompareBook implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return (int)(o1.price - o2.price);
    }
}
