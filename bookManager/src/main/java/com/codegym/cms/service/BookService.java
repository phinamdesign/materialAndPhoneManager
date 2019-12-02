package com.codegym.cms.service;

import com.codegym.cms.model.Book;
import com.codegym.cms.model.Category;

import java.awt.print.Pageable;

public interface BookService {
    Iterable<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void remove(Long id);

    Iterable<Book> findAllByCategory(Category category);
}
