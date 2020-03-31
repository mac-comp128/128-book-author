package edu.macalester.comp128.bookml;

import java.util.*;

/**
 * A class to guess authors of a book.
 *
 * The intended use of this object is that it would be instantiated once, but used
 * many times.
 *
 */
public class AuthorGuesser {
    // an array containing the file name of all the provided books with known
    // authors. This array will help you load in all the books for future
    // reference.
    private static final String[] BOOK_FILES = {"74-0.txt",
            "76-0.txt",
            "86-0.txt",
            "119-0.txt",
            "121-0.txt",
            "158-0.txt",
            "245-0.txt",
            "294-0.txt",
            "1212-0.txt",
            "1644-0.txt",
            "1837-0.txt",
            "2895-0.txt",
            "3171-0.txt",
            "3174-0.txt",
            "3176-0.txt",
            "3177.txt",
            "3178-0.txt",
            "3179-0.txt",
            "3180-0.txt",
            "4295-0.txt",
            "5260-0.txt",
            "pg105.txt",
            "pg126.txt",
            "pg355.txt",
            "pg423.txt",
            "pg946.txt",
            "pg1213.txt",
            "pg1638.txt",
            "pg1661.txt",
            "pg2097.txt",
            "pg2343.txt",
            "pg2344.txt",
            "pg2345.txt",
            "pg2346.txt",
            "pg2347.txt",
            "pg2348.txt",
            "pg2349.txt",
            "pg42671.txt",
            "pg19484.txt",
            "pg21839.txt"};


    // parameter to the guessing algorithm.
    private int k;
    // similarity method to use as part of guessing algorithm.
    private SimilarityMethod similarity;

    //TODO: any other instance variables

    public AuthorGuesser(int k, SimilarityMethod similarty) {
        //TODO: assign values to instance variables
        //TODO: process all the book files into Book Objects for future use.
    }

    /**
     * Given a book whose author is unknown, or assumed to be wrong, guess the
     * correct author using the k-nearest-neighbors algorithm.
     *
     * This method should be programed in a way that it can be called more than
     * once, with different books, without creating a new AuthorGuesser each time.
     *
     * @param unknownAuthorBook - the book object describing the book with unknown
     *                          author
     * @return - the name of the algorithm's best guess for the true author of the
     * unknown author book.
     */
    public String guessAuthor(Book unknownAuthorBook) {
        //TODO: your goal is to implement this.
        return null; // obviously, this is not the correct return value
    }

    // TODO: you will need to decompose this algorithm into several functions.
    // put any helper functions here.

    /**
     * Given a list of book return the author that appears the most
     * @param books - a list of books
     * @return the most common author in books
     */
    public String mostCommonAuthor(List<Book> books) {
        Map<String, Integer> countAuthors = new HashMap<>();
        for(Book b: books) {
            if(countAuthors.containsKey(b.getAuthor())) {
                countAuthors.put(b.getAuthor(), 1+countAuthors.get(b.getAuthor()));
            } else {
                countAuthors.put(b.getAuthor(), 1);
            }
        }
        int authorMax = -1;
        String maxAuthor = null;

        //NOTE - this is a good example of how to iterate over the keys of a map.
        for(String author: countAuthors.keySet()) {
            int count = countAuthors.get(author);
            if(count > authorMax) {
                maxAuthor = author;
                authorMax = count;
            }
        }
        return maxAuthor;
    }

}