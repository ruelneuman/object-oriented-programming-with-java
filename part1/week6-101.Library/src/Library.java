/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rueln
 */
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library;

    public Library() {
        this.library = new ArrayList<Book>();
    }

    public void addBook(Book newBook) {
        this.library.add(newBook);
    }

    public void printBooks() {
        for (Book book : this.library) {
            System.out.println(book);
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        return searchBook(title, null, -1);
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        return searchBook(null, publisher, -1);
    }

    public ArrayList<Book> searchByYear(int year) {
        return searchBook(null, null, year);
    }

    // Helper method
    public ArrayList<Book> searchBook(String title, String bookName, int year) {
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book book : this.library) {
            if (StringUtils.included(book.title(), title)
                    || StringUtils.included(book.publisher(), bookName)
                    || (book.year() == year && book.year() >= 0)) {
                found.add(book);
            }
        }

        return found;
    }

}
