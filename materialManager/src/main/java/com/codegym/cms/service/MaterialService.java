package com.codegym.cms.service;

import com.codegym.cms.model.Material;
import com.codegym.cms.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MaterialService {

    Page<Material> findAll(Pageable pageable);

    Material findById(Long id);

    void save(Material material);

    void remove(Long id);

    Iterable<Material> findAllBySupplier(Supplier supplier);

    Page<Material> findAllByNameContaining(String name, Pageable pageable);
}
