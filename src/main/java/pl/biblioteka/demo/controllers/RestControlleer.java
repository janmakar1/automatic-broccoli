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

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
        List<Orders> usersOrders = orderRepo.findByNickName(nick);
        return usersOrders;
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    @GetMapping("/days/{nick}")
    public int showDaysOfOneBookForUser(@PathVariable String nick){
        Date date = new Date();
        LocalDate localDate =  convertToLocalDateViaInstant(date);

        LocalDate now = LocalDate.now();

        List<Orders> usersOrders = orderRepo.findByNickName(nick);
        Orders oneOrder = usersOrders.stream().findFirst().get();
        Date thenDate = oneOrder.getDates();
        LocalDate then = convertToLocalDateViaInstant(thenDate);

        Period period = Period.between(then, now);
        int days = period.getDays();

        return days;
    }

//    @GetMapping("/kara/{nick}")
//    public int showPenaltyForUser(@PathVariable String nick){
//        Date date = new Date();
//        LocalDate localDate =  convertToLocalDateViaInstant(date);
//
//        LocalDate now = LocalDate.now();
//
//        List<Orders> usersOrders = orderRepo.findByNickName(nick);
//        Orders oneOrder = usersOrders.stream().filter((order) -> {
//            LocalDate ld = convertToLocalDateViaInstant(order.getDates());
//            Period difference = Period.between()
//        })
//
//        Date thenDate = oneOrder.getDates();
//        LocalDate then = convertToLocalDateViaInstant(thenDate);
//
//        Period period = Period.between(then, now);
//        int days = period.getDays();
//
//        return days;
//    }


}
