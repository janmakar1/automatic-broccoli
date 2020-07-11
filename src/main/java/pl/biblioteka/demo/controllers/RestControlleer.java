package pl.biblioteka.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.biblioteka.demo.classes.Book;
import pl.biblioteka.demo.classes.Orders;
import pl.biblioteka.demo.repo.BookRepo;
import pl.biblioteka.demo.repo.OrderRepo;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
public class RestControlleer {

    private static final int DAYS_USER_CAN_KEEP_BOOK = 3; // .. can keep book without penalty
    private static final int PENALTY_IN_PLN_PER_DAY = 2; // .. can keep book without penalty

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

    private void printArray(Object[] objects){
        System.out.println("--");
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i] + ", ");
        }
        System.out.println("--");
    }

    /**
    funkcja pomocnicza obliczajaca roznice miedzy dniem wypozyczenia ksiazki a dniem dzisiejszym
     */
    private int findDays(LocalDate then) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(then, now);
        return period.getDays();
    }

    /**
    podobna funkcja do findDays, tylko, ze mozna ustawic konkretna date (do testow jednostkowych)
     */
    public int findDaysBetween(LocalDate then, LocalDate now) {
        return Period.between(then, now).getDays();
    }

    @GetMapping("/days/{nick}")
    public int showDaysOfOneBookForUser(@PathVariable String nick){

        LocalDate now = LocalDate.now();

        List<Orders> usersOrders = orderRepo.findByNickName(nick);
        Orders oneOrder = usersOrders.stream().findFirst().get();
        LocalDate then = oneOrder.getStartDate();
        return findDays(then);
    }

    @GetMapping("/penalty/{nick}")
    public int showPenaltyForUser(@PathVariable String nick){
        List<Orders> usersOrders = orderRepo.findByNickName(nick);
        int a = usersOrders.stream()
                .filter((order) -> {
                    return findDays(order.getStartDate()) > DAYS_USER_CAN_KEEP_BOOK;
                }).mapToInt((order) -> {
                    return findDays(order.getStartDate()) - DAYS_USER_CAN_KEEP_BOOK;
                }).sum();
        return a * PENALTY_IN_PLN_PER_DAY;
    }


}
