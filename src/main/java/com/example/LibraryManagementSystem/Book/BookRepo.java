package com.example.LibraryManagementSystem.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Long> {

 @Query("SELECT b FROM Book b where b.id=?1")
 Optional<Book> findBookById(String id);

 @Query("SELECT b FROM Book b where b.title=?1")
 Optional<Book> findBookByTitle(String title);


}
