package edu.macalester.comp128.bookml;

import java.io.InputStream;
import java.util.*;

/**
 * A class to represent a book.
 */
public class Book {
    private static final String AUTHOR_PREFIX = "Author: ";
    private static final String TITLE_PREFIX = "Title: ";
    private static final String START_PREFIX1 = "*** START OF THIS PROJECT GUTENBERG EBOOK";
    private static final String STOP_PREFIX1 = "*** END OF THIS PROJECT GUTENBERG EBOOK";
    private static final String START_PREFIX2 = "***START OF THE PROJECT GUTENBERG EBOOK";
    private static final String STOP_PREFIX2 = "***END OF THE PROJECT GUTENBERG EBOOK";

    private String title;
    private String author;
    private Map<String, Integer> wordCounts;
    private String fileName;

    public Book(String fileName) {
        this.fileName = fileName;
        wordCounts = new HashMap<>();

        // create a scanner object to read the file.
        Scanner scanner = openScanner(fileName);

        // read the header block of the file.
        readHeader(scanner);

        readFile(scanner);
        this.fileName = fileName;
    }



    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    }

    public String getFileName() {
        return fileName;
    }

    /* Private methods, used in the implementation of the constructor */

    private void readFile(Scanner scanner) {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith(STOP_PREFIX1) ||
                    line.startsWith(STOP_PREFIX2)) {
                break;
            }
            String[] words = line.split("\\s+");
            for(String word : words) {
                word = clean(word);
                // some "words" are just rouge punctuation. These get cleaned
                // to the empty string (""). Ignore these.
                if (!word.isEmpty()) {
                    if (wordCounts.containsKey(word)) {
                        wordCounts.put(word, 1 + wordCounts.get(word));
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
            }
        }
    }

    /**
     * creates a "clean" version of the word by removing punctuation and making words lowercase.
     * @param word The word to clean
     * @return The clean word.
     */
    private String clean(String word) {
        word = word.toLowerCase();
        word = word.replaceAll("[^a-z0-9]","");
        return word;
    }

    /**
     * Helper method for the constructor. Reads the header & license that project gutenburg attaches to all of
     * Their books. We do not want to read those lines as words.
     * @param scanner The scanner to read from. This object will be advanced to right after the header.
     */
    private void readHeader(Scanner scanner) {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith(TITLE_PREFIX)) {
                this.title = line.substring(TITLE_PREFIX.length());
            } else if (line.startsWith(AUTHOR_PREFIX)) {
                this.author = line.substring(AUTHOR_PREFIX.length());
            } else if (line.startsWith(START_PREFIX1) ||
                    line.startsWith(START_PREFIX2)) {
                break;
            }

        }
    }


    /**
     * Helper method to aid in opening text files.
     * @param fileName - the name of the file to read
     * @return A scanner object for that file.
     */
    private static Scanner openScanner(String fileName) {
        InputStream stream = Book.class.getResourceAsStream("/"+fileName);
        return new Scanner(stream, "utf-8");
    }
}
