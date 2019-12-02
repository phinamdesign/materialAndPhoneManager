package com.codegym.cms.repository;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {
    Iterable<Phone> findAllByCategory(Category category);
    Page<Phone> findAllByNameOrderByNameAsc(String name, Pageable pageable);
}
