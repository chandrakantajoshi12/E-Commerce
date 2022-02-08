package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, String> {
//    private deleteByUsername(username) {
//
//    }
}
