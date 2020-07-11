package pl.biblioteka.demo.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.biblioteka.demo.controllers.RestControlleer;
import pl.biblioteka.demo.repo.BookRepo;
import pl.biblioteka.demo.repo.OrderRepo;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RestControlleerTest {

    public BookRepo bookRepository;
    public OrderRepo orderRepository;
    public RestControlleer restControlleer;

    @BeforeEach
    public void setup() {
        restControlleer = new RestControlleer(bookRepository, orderRepository);
    }

    @Test
    public void findDaysBetweenTest() {
        //given
        LocalDate localDate = LocalDate.of(2020, 7, 6);
        LocalDate localDate2 = LocalDate.of(2020, 7, 7);
        //when
        int days = restControlleer.findDaysBetween(localDate, localDate2);
        //then
        assertThat(days).isEqualTo(1);
    }
}
