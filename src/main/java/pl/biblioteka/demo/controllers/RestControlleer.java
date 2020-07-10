package pl.biblioteka.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.biblioteka.demo.classes.Book;
import pl.biblioteka.demo.repo.BookRepo;

import java.util.List;

@RestController
public class RestControlleer {

    public BookRepo bookRepo;

    @Autowired
    public RestControlleer(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/zestawienie")
    public List<Book> all() {
        return bookRepo.findAll();
    }


    @GetMapping("/{nick}")
    public String showKara(){
        return "";
    }

}
