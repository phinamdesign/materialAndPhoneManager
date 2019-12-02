package com.codegym.cms.repository;

import com.codegym.cms.model.Book;
import com.codegym.cms.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Iterable<Book> findAllByCategory(Category category);
}
