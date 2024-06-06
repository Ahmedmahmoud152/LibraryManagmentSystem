package com.example.LibraryManagementSystem.Book;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepo bookRepo;

    public BookServices(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBookRepo() {
        return bookRepo.findAll();
    }

    public Book getBookRepo(Long id) {
        Optional<Book> book = bookRepo.findById(id);
        return book.orElseThrow(() -> new IllegalStateException("Book is not found"));
    }

    public void addBook(Book book) {
        Optional<Book> optionalBook = bookRepo.findById(book.getId());
        if (optionalBook.isPresent()) {
            throw new IllegalStateException("Book is exist");
        }
        bookRepo.save(book);
    }

    public void deleteStudent(Long bookId) {
        boolean exists = bookRepo.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException(
                    "Book with id:" + bookId + "does not found");
        }
        bookRepo.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long id, String title, String author, LocalDate publishYear, String ISBN) {
        Book book = bookRepo.findById(id).
                orElseThrow(() -> new IllegalStateException(
                        "Book with id " + id + " does not found"));
        if (title != null && !title.isEmpty() &&
                !Objects.equals(book.getTitle(), title)) {
            book.setTitle(title);
        }
        if (author != null && !author.isEmpty() &&
                !Objects.equals(book.getAuthor(), author)) {
            book.setAuthor(author);
        }
        if (publishYear != null && !Objects.equals(book.getPublishYear(), publishYear)) {
            book.setPublishYear(publishYear);
        }
        if (ISBN != null && !ISBN.isEmpty() &&
                !Objects.equals(book.getISBN(), ISBN)) {
            book.setISBN(ISBN);
        }


    }


}
