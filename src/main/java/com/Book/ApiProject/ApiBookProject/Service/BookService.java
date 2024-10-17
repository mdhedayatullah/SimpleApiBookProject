package com.Book.ApiProject.ApiBookProject.Service;

import com.Book.ApiProject.ApiBookProject.Entities.Books;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private static List<Books> books = new ArrayList<Books>();
    static {
        books.add(new Books(111, "java complite book reference ", "Author1"));
        books.add(new Books(222, "Python coplite book reference", "Author2"));
        books.add(new Books(333, "JavaScript Complite reference ", "Author3"));
    }

    //All books finding
    public List<Books> getAllBooks() {
        return books;
    }
    //Only one book found
     public Books getBookById(int id){
        Books book1 = null;
        book1= books.stream().filter(e->e.getId()==id).findFirst().get();
        return book1;
     }
}
