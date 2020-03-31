package edu.macalester.comp128.bookml;

/**
 * An interface to represent a similarity method.
 * Each implementation of this class represents a different way to check how
 * similar two books are. The AuthorGuesser object will have an instance of this
 * which is uses as part of its algorithm.
 */
public interface SimilarityMethod {
    double computeSimilarity(Book b1, Book b2);
}
