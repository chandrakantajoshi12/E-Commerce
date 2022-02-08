package engineer.chandrakanta.Gallery.Service;

import engineer.chandrakanta.Gallery.Repository.WomenWearRepository;
import engineer.chandrakanta.Gallery.entity.Customer;
import engineer.chandrakanta.Gallery.entity.WomenWear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WomenWearService {
    @Autowired
    private WomenWearRepository womenRepository;

   public  WomenWear createWomenWear(WomenWear womenWear){
       return womenRepository.save(womenWear);
   }

   public List<WomenWear> showDetails(){
       return womenRepository.findAll();
   }
//    public List<Customer> showsDetails(){
//
//        return customerRepository.findAll();
//    }
}
