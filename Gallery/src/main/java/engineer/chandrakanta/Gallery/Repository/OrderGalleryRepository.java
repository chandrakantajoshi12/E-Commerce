package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.OrderGallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderGalleryRepository extends JpaRepository<OrderGallery,Long> {

     public List<OrderGallery> findByCustomerUsername(String username);
}
