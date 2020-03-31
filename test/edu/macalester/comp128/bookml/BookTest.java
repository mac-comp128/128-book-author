package edu.macalester.comp128.bookml;


import org.junit.Test;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * A class to test the Book class.
 */
public class BookTest {

    @Test
    public void testConstructorAuthor() {
        Book tomSawyer = new Book("74-0.txt");
        assertEquals("Mark Twain (Samuel Clemens)", tomSawyer.getAuthor());

        Book abbey = new Book("121-0.txt");
        assertEquals("Jane Austen", abbey.getAuthor());

        Book songs = new Book("4295-0.txt");
        assertEquals("Arthur Conan Doyle", songs.getAuthor());
    }

    @Test
    public void testConstructorTitle() {
        Book tomSawyer = new Book("74-0.txt");
        assertEquals("The Adventures of Tom Sawyer, Complete", tomSawyer.getTitle());

        Book abbey = new Book("121-0.txt");
        assertEquals("Northanger Abbey", abbey.getTitle());

        Book songs = new Book("4295-0.txt");
        assertEquals("Songs of Action", songs.getTitle());
    }

    @Test
    public void wordCountTest() {
        // NOTE: no test can guarantee that your code is correct. This test does a quick and dirty job of checking a few
        // words that we expect in only one document.

        Book dogsTale = new Book("3174-0.txt");
        Map<String, Integer> words = dogsTale.getWordCounts();
        assertMapContent(words, "footman", 4);
        assertMapContent(words, "blind", 1);
        assertMapContent(words, "doggie", 2);
        assertMapContent(words, "father", 1);
        assertMapContent(words, "bernard", 1);
        assertMapContent(words, "mothers", 3);
        assertMapContent(words, "mother", 16);

    }

    /**
     * helpeful assert method to check that the map both contains a key and that it is the correct value.
     */
    public static <K, V> void assertMapContent(Map<K, V> map, K key, V value) {
        assertTrue("The map should contain "+key, map.containsKey(key));
        assertEquals(value, map.get(key));
    }
}
