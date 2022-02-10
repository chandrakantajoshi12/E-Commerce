package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByCustomerUserName(String userName);
}
