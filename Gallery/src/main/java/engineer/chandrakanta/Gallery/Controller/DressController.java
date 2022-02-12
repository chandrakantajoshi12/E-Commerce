package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.CustomerRepository;
import engineer.chandrakanta.Gallery.Repository.DressRepository;
import engineer.chandrakanta.Gallery.Service.CustomerService;
import engineer.chandrakanta.Gallery.Service.DressService;
import engineer.chandrakanta.Gallery.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DressController {
   @Autowired
    DressService dressService;
   @Autowired
    DressRepository dressRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/buyDress/{id}")
    public String buyDress(@PathVariable Long id, Model model){
        Dress dress  = dressService.getById(id);
//        Customer customer = customerService.findByUsername(username);
      OrderDress orderDress = new OrderDress();
      orderDress.setDress(dress);
//      orderDress .setCustomer(customer);
        return "buyDress";
    }

    @GetMapping("/dressTable")
    public  String customerTable(Model model){
        List<Dress> dress =dressService.allDress();
        model.addAttribute("dress",dress);
        return  "dressTable";
    }
}
