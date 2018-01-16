package com.kurylo.service;

import com.kurylo.domain.Books;
import com.kurylo.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public List<Books> findAllBooks(){
        List<Books> books = new ArrayList<Books>();
        for(Books book:  booksRepository.findAll())
            books.add(book);
        return books;
    }

    public List<Books> findAllBooksByBookName(String book_name){
        List<Books> booksByName = new ArrayList<Books>();
        for(Books book:  booksRepository.findAllBybookName(book_name))
            booksByName.add(book);
        return booksByName;
    }


    public void saveBook(Books book){
        booksRepository.save(book);
    }

    public void deleteBook(Long id){
        booksRepository.delete(id);
    }

    public Books findBook(Long id){
        return booksRepository.findOne(id);
    }


}

