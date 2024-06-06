package com.example.LibraryManagementSystem.Book;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Book {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String title;
    private String author;
    private LocalDate publishYear;
    @Column(unique = true)
    private String ISBN;

    public Book() {
    }

    public Book(Long id, String title, String author, LocalDate publishYear, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.ISBN = ISBN;
    }

    public Book(String title, String author, LocalDate publishYear, String ISBN) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.ISBN = ISBN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDate publishYear) {
        this.publishYear = publishYear;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
