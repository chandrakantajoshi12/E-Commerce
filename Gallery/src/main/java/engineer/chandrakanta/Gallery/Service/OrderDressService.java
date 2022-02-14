package engineer.chandrakanta.Gallery.Service;

import engineer.chandrakanta.Gallery.Repository.OrderDressRepository;
import engineer.chandrakanta.Gallery.entity.OrderDress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDressService {
 @Autowired
 private OrderDressRepository orderDressRepository;

     public OrderDress addOrder(OrderDress orderDress){

     return  orderDressRepository.save(orderDress);
    }
     public List<OrderDress> orderDress(String username){

     return orderDressRepository.findByCustomerUsername(username);
      }
    public void  remove(Long id){
      orderDressRepository.deleteById(id);
    }


}
