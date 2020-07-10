package pl.biblioteka.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biblioteka.demo.classes.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
}
