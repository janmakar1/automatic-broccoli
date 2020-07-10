package pl.biblioteka.demo.classes;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tytul;
    private String autor;
    private String opis;

    @Enumerated(value = EnumType.STRING)
    private Gatunek gatunek;

    public Book() {
    }

    public Book(String tytul, String autor, String opis, Gatunek gatunek) {
        this.tytul = tytul;
        this.autor = autor;
        this.opis = opis;
        this.gatunek = gatunek;
    }

    public Book(String tytul, String autor, String opis) {
        this.tytul = tytul;
        this.autor = autor;
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(Gatunek gatunek) {
        this.gatunek = gatunek;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", opis='" + opis + '\'' +
                ", gatunek=" + gatunek +
                '}';
    }

    public static enum Gatunek {
        Komedia,
        Romantyczna,
        Historyczna
    }
}
