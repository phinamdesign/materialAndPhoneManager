package com.codegym.cms.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(targetEntity = Book.class)
    private List<Book> books;

    public Category() {
    }

    public Category(String name, String description, List<Book> books) {
        this.name = name;
        this.description = description;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getPhones() {
        return books;
    }

    public void setPhones(List<Book> phones) {
        this.books = phones;
    }
}
