package com.Book.ApiProject.ApiBookProject.BookContollers;

import com.Book.ApiProject.ApiBookProject.Entities.Books; // Import Books class
import com.Book.ApiProject.ApiBookProject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
   //Get all books handler

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBook() {
//        Books books = new Books();

        List<Books> list  =this.bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }
//Get single book handler
    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable("id") int id){
              Books  b =   this.bookService.getBookById(id);
              if(b == null){
                  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();// Replace 1 with the id of the book you want to retrieve
              }
              return ResponseEntity.of(Optional.of(b));
    }
//Create new book handler
   @PostMapping("/books")
   public ResponseEntity<Books> addBook(@RequestBody Books book){
       Books b = null;
       try {
           b =this.bookService.addBook(book);
           System.out.println(b);
           return ResponseEntity.of(Optional.of(b));
       }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    //Delete books handler
    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookId){
        try {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //Update book handler

    @PutMapping("/books/{bookid}")
    public ResponseEntity<Books> updateBook(@RequestBody Books books,@PathVariable("bookid") int bookId){
       try {
           this.bookService.updateBook(books,bookId);
           return ResponseEntity.ok().body(books);
       }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }


    }
}
