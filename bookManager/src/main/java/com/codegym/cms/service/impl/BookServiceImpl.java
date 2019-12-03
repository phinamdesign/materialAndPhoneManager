package com.codegym.cms.service.impl;

import com.codegym.cms.model.Book;
import com.codegym.cms.model.Category;
import com.codegym.cms.repository.BookRepository;
import com.codegym.cms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Iterable<Book> findAllByCategory(Category category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public Page<Book> findAllByNameContaining(String name, Pageable pageable) {
        return bookRepository.findAllByNameContaining(name, pageable);
    }
}
