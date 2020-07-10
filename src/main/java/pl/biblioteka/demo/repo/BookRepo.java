package pl.biblioteka.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biblioteka.demo.classes.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
