package com.kurylo.domain;

import javax.persistence.*;

@Entity(name="books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column
    private String author;


    Books(){}

    public Books(String bookName,String author){
        this.bookName = bookName;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_name() {
        return bookName;
    }

    public void setBook_name(String book_name) {
        this.bookName = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String doctor_name) {
        this.author = doctor_name;
    }

    @Override
    public String toString() {
        return "RegisteredPatient [id= "+id+", book_name= "+bookName+", author= "+author+ " ]";
    }
}
