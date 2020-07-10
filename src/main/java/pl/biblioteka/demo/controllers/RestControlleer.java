package pl.biblioteka.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.biblioteka.demo.classes.Book;
import pl.biblioteka.demo.classes.Orders;
import pl.biblioteka.demo.repo.BookRepo;
import pl.biblioteka.demo.repo.OrderRepo;

import java.util.Date;
import java.util.List;

@RestController
public class RestControlleer {

    public BookRepo bookRepo;
    private OrderRepo orderRepo;

    @Autowired
    public RestControlleer(BookRepo bookRepo, OrderRepo orderRepo) {
        this.bookRepo = bookRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping("/zestawienie")
    public List<Book> all() {
        return bookRepo.findAll();
    }

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }


    @GetMapping("/zestawienie/{nick}")
    public List<Orders> showBooksOrderedBy(@PathVariable String nick){
        Date date = new Date();

        List<Orders> usersOrders = orderRepo.findByNickName(nick);

        return usersOrders;
    }

}
