package engineer.chandrakanta.Gallery.Service;

import engineer.chandrakanta.Gallery.Repository.CustomerRepository;
import engineer.chandrakanta.Gallery.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository  customerRepository ;
    public Customer createCustomer(Customer customer){

        return customerRepository.save(customer);
    }

    public boolean existsByUsername(String userName) {

        return   customerRepository.existsById(userName);
    }

    public Customer findByUsername(String userName) {

        return  customerRepository.getById(userName);
    }
    public List<Customer> showsDetails(){

        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }
//    public  Customer deleteByUserName(String userName){
//        return customerRepository.deleteById(userName);
//    }
}
