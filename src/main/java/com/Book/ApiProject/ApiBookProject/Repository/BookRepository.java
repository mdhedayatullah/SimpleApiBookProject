package com.Book.ApiProject.ApiBookProject.Repository;

import com.Book.ApiProject.ApiBookProject.Entities.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books,Integer> {
    public Books findById(int id);
}
