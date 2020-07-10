package pl.biblioteka.demo.classes;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String bookName;
    private String nickName;
    private String names;
    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    public Orders() {
    }

    public Orders(String bookName, String nickName, String names, String surname, LocalDate startDate) {
        this.bookName = bookName;
        this.nickName = nickName;
        this.names = names;
        this.surname = surname;
        this.startDate = startDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", names='" + names + '\'' +
                ", surname='" + surname + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
