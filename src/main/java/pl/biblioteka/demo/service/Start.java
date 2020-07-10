package pl.biblioteka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.biblioteka.demo.classes.Book;
import pl.biblioteka.demo.classes.Orders;
import pl.biblioteka.demo.repo.BookRepo;
import pl.biblioteka.demo.repo.OrderRepo;

import java.time.LocalDate;
import java.util.Date;

@Component
public class Start {
    public OrderRepo orderRepo;
    public BookRepo bookRepo;

    @Autowired
    public Start(BookRepo bookRepo, OrderRepo orderRepo){
        this.bookRepo = bookRepo;
        this.orderRepo = orderRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void start(){

        bookRepo.save(new Book("Jozin z Bazin ", "Jozin ", "Jozin z bazin to świetna bajka komediowa ", Book.Gatunek.Komedia));
        bookRepo.save(new Book("Harry Potter ", "J.K. Rowling ", "Harry Potter i więzień Azkabanu ", Book.Gatunek.Komedia));
        bookRepo.save(new Book("2 wojna światowa ", "Hitler ", "Opowieść o 2 wojnie światowej ", Book.Gatunek.Historyczna));
        bookRepo.save(new Book("Dwie pary mlode ", "Joanna Bags ", "Opowieść o 2 parach mlodych ", Book.Gatunek.Romantyczna));

        orderRepo.save(new Orders("Nazwa ksiazki", "Radq", "radek", "gackowski", new Date()));

    }

}
