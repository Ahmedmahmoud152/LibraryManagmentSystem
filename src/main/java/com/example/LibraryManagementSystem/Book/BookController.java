package com.example.LibraryManagementSystem.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookServices bookServices;


    @GetMapping
    public List<Book> getBook() {
        return bookServices.getAllBookRepo();
    }

    @GetMapping("{bookId}")
    public Book getBook(@PathVariable ("bookId")Long id) {
        return bookServices.getBookRepo(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookServices.addBook(book);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {

        bookServices.deleteStudent(id);

    }

    @PutMapping(path = "{bookId}")
    public void updateStudent(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) LocalDate pulishYear,
            @RequestParam(required = false) String ISBN
    ) {
        bookServices.updateBook(bookId, title, author, pulishYear, ISBN);
        System.out.println("Update everything");
    }

}
