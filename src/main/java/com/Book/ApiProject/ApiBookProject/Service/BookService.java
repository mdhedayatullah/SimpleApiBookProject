package com.Book.ApiProject.ApiBookProject.Service;

import com.Book.ApiProject.ApiBookProject.Entities.Books;
import com.Book.ApiProject.ApiBookProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
//    private static List<Books> list = new ArrayList<Books>();
//    static {
//        list.add(new Books(111, "java complite book reference ", "Author1"));
//        list.add(new Books(222, "Python coplite book reference", "Author2"));
//        list.add(new Books(333, "JavaScript Complite reference ", "Author3"));
//    }

    //All books finding
    public List<Books> getAllBooks() {
        //Typecaste the variables
       List<Books> list= (List<Books>) this.bookRepository.findAll();
        return list;
    }
    //Only one book found
     public Books getBookById(int id){
        Books book1 = null;
        try {
           book1 = this.bookRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book1;
     }
     //Adding the book
     public Books addBook(Books b){
      Books result= bookRepository.save(b);
        return result;
     }
//Delete the book
    public void deleteBook(int bookId) {
//        list = list.stream().filter(book->{
//           if(book.getId() != bookId){
//               return true;
//           }else {
//               return false;
//           }
//
//       }).collect(Collectors.toList());

        bookRepository.deleteById(bookId);
    }
//Update the book
    public void updateBook(Books books,int bookId) {
//       list = list.stream().map(b->{
//           if(b.getId() == bookId){
//               b.setTitle(books.getTitle());
//               b.setAuthor(books.getAuthor());
//           }
//           return b;
//       }).collect(Collectors.toList());

        books.setId(bookId);
        bookRepository.save(books);
    }
}
