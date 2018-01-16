package com.kurylo.repository;

import com.kurylo.domain.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books, Long> {

    List<Books> findAllBybookName(String book_name);
}
