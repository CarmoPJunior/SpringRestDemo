package com.example.SpringRestDemo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.SpringRestDemo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
