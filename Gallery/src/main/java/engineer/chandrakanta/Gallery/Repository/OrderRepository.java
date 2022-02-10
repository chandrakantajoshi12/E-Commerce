package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
