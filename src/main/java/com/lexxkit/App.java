package com.lexxkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int NUMBER_OF_SHELVES = 5;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(setBooksByShelves(List.of("d", "a", "c", "b")));
        System.out.println("---------");
        System.out.println(setBooksByShelves(List.of("b", "d", "a", "c", "g", "e", "a")));

    }

    public static Map<Integer, List<String>> setBooksByShelves(List<String> books) {
        Map<Integer, List<String>> shelves = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_SHELVES; i++) {
            shelves.put(i, new ArrayList<>());
        }

        List<String> sortedBooks = books.stream().sorted().collect(Collectors.toList());

        int booksPerShelf = sortedBooks.size() / NUMBER_OF_SHELVES;
        int remainBooks = sortedBooks.size() % NUMBER_OF_SHELVES;
        int currentBookIdx = 0;

        for (int i = 0; i < shelves.size(); i++) {
            List<String> shelf = shelves.get(i);
            for (int j = 0; j < booksPerShelf; j++) {
                shelf.add(sortedBooks.get(currentBookIdx++));
            }
            if (remainBooks > 0) {
                shelf.add(sortedBooks.get(currentBookIdx++));
                remainBooks--;
            }
        }

        return shelves;
    }

}
