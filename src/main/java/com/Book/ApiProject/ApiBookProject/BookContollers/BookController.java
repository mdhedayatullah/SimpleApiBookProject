package com.Book.ApiProject.ApiBookProject.BookContollers;

import com.Book.ApiProject.ApiBookProject.Entities.Books; // Import Books class
import com.Book.ApiProject.ApiBookProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public List<Books> getBook() {
        Books books = new Books();
        return this.bookService.getAllBooks();

    }

    @GetMapping("/books/{id}")
    public Books getBookById(@PathVariable("id") int id){
        return this.bookService.getBookById(id); // Replace 1 with the id of the book you want to retrieve
    }
}
