package pl.biblioteka.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.biblioteka.demo.classes.Orders;
import pl.biblioteka.demo.repo.BookRepo;
import pl.biblioteka.demo.repo.OrderRepo;

@Controller
public class ControllerWypozyczen {
    private OrderRepo orderRepo;
    private BookRepo bookRepo;

    @Autowired
    public ControllerWypozyczen(BookRepo bookRepo, OrderRepo orderRepo) {
        this.bookRepo = bookRepo;
        this.orderRepo = orderRepo;
    }


    @GetMapping("/")
    public String home(){
        return "home";
    }



    @GetMapping("/wypozyczenie")
    public String wypozycz(Model model){

        model.addAttribute("listBook", bookRepo.findAll()); //wyświetlenie

       // Wypozyczenia wypozyczenia = new Wypozyczenia();
       // model.addAttribute("wypozyczenie", wypozyczenia);

        Orders orders = new Orders();
        model.addAttribute("orders", orders);

        return "wypozyczenie";
    }

  /*  @PostMapping("/wypozyczenie")
    public String wypozyczBook(@ModelAttribute("wypozyczenie") Wypozyczenia wypozyczenia){
        //wypozyczeniaRepo.save(new Wypozyczenia(wypozyczenia.getNazwaKsiazki(), wypozyczenia.getNick(), wypozyczenia.getNazwisko(), wypozyczenia.getImie(), LocalDate.now()));
        wypozyczeniaRepo.save(new Wypozyczenia("Nazwa książki", "radq", "nazwisko", "imie", LocalDate.of(1998, 11, 11)));

        //System.out.println(wypozyczenia.getNazwaKsiazki());
       // System.out.println(wypozyczenia.getNick());
       // System.out.println(wypozyczenia.getNazwisko());
      // System.out.println(wypozyczenia.getImie());
       // System.out.println(LocalDate.now());

        return "wypozyczenie";
    } */
    @PostMapping("/wypozyczenie")
    public String wypozyczPls(@ModelAttribute("orders") Orders orders){
//        orderRepo.save(new Orders(orders.getBookName(), orders.getNickName(), orders.getNames(), orders.getSurname(), new Date()));
        orderRepo.save(new Orders(orders.getBookName(), orders.getNickName(), orders.getNames(), orders.getSurname(), orders.getStartDate()));
        //String bookName, String nickName, String names, String surname, LocalDate dates
        return "wypozyczenie";
    }

}
