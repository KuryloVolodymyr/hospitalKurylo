package com.kurylo.controller;

import com.kurylo.domain.Books;
import com.kurylo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-books")
    public String allBooks(HttpServletRequest request) {
        request.setAttribute("books", booksService.findAllBooks());
        request.setAttribute("mode", "MODE_BOOKS");
        return "index";
    }

    @GetMapping("/new-book")
    public String newBook(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @GetMapping("/update-book")
    public String updateBook(@RequestParam Long id, HttpServletRequest request) {
        request.setAttribute("book", booksService.findBook(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @GetMapping("/delete-book")
    public String deleteBook(@RequestParam Long id, HttpServletRequest request) {
        booksService.deleteBook(id);
        request.setAttribute("books", booksService.findAllBooks());
        request.setAttribute("mode", "MODE_OK");
        return "index";
    }

    @GetMapping("/ok")
    public String okResult(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/error")
    public String error(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }


    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute Books book, BindingResult bindingResult, HttpServletRequest request) {
        booksService.saveBook(book);
        request.setAttribute("books", booksService.findAllBooks());
        request.setAttribute("mode", "MODE_OK");
        return "index";
    }

    @GetMapping("/book-search-page")
    public String searchPage(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_SEARCH");
        return "index";
    }

    @GetMapping("/search")
    public String searchPatient(@ModelAttribute Books book, BindingResult bindingResult, HttpServletRequest request) {
        request.setAttribute("booksFound", booksService.findAllBooksByBookName(book.getBook_name()));
        if (booksService.findAllBooksByBookName(book.getBook_name()).isEmpty()) {
            request.setAttribute("mode", "MODE_NOTHING_FOUND");
        }
        else {
            request.setAttribute("mode", "MODE_FOUND");
        }
        return "index";
    }


}
