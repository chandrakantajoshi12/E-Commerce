package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.OrderDress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDressRepository extends JpaRepository<OrderDress,Long> {
     public List<OrderDress> findByCustomerUsername(String username);
}
