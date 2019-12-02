package com.codegym.cms.controller;

import com.codegym.cms.model.Book;
import com.codegym.cms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ModelAndView listBook(){
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("book", books);
        return modelAndView;
    }

    @GetMapping("/create-book")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Them moi thanh cong !");
        return modelAndView;
    }

    @GetMapping("/edit-book/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        if (book != null){
            ModelAndView modelAndView = new ModelAndView("/book/edit");
            modelAndView.addObject("book", book);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-book")
    public ModelAndView editBook(@ModelAttribute("book") Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Sua thanh cong !");
        return modelAndView;
    }

    @GetMapping("/delete-book/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        if(book != null){
            ModelAndView modelAndView = new ModelAndView("/book/delete");
            modelAndView.addObject("book", book);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/book/delete");
            return modelAndView;
        }
    }

    @PostMapping("/delete-book")
    public String deleteBook(@ModelAttribute("book") Book book){
        bookService.remove(book.getId());
        return "redirect:books";
    }
}
