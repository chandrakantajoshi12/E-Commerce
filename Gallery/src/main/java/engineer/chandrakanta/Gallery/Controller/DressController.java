package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.CustomerRepository;
import engineer.chandrakanta.Gallery.Repository.DressRepository;
import engineer.chandrakanta.Gallery.Repository.OrderDressRepository;
import engineer.chandrakanta.Gallery.Service.CustomerService;
import engineer.chandrakanta.Gallery.Service.DressService;
import engineer.chandrakanta.Gallery.Service.OrderDressService;
import engineer.chandrakanta.Gallery.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
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
    @Autowired
    OrderDressRepository orderDressRepository;
    @Autowired
    OrderDressService orderDressService;

    @GetMapping("/buyDress/{id}")
    public String buyDress(@PathVariable Long id, Principal principal, Model model){
        if(principal!=null){
            String username = principal.getName();
            model.addAttribute("username",username);
        }
        Dress dress  = dressService.getById(id);
        Customer customer = customerService.findByUsername(principal.getName());
      OrderDress orderDress = new OrderDress();
      orderDress.setDress(dress);
      orderDress .setCustomer(customer);
      orderDressService.addOrder(orderDress);
        return "buyDress";
    }

//    @GetMapping("/buyGallery/{id}")
//    public String buyNow(@PathVariable Long id, Principal principal, Model model){
//        if(principal!=null){
//            String username = principal.getName();
//            model.addAttribute("username",username);
//        }
//        Gallery gallery = galleryService.getById(id);
//        Customer customer = customerService.findByUsername(principal.getName());
//        OrderGallery orderGallery = new OrderGallery();
//        orderGallery.setGallery(gallery);
//        orderGallery.setCustomer(customer);
//        orderGalleryService.addOrderGallery(orderGallery);
//        return "buyGallery";
//    }

    @GetMapping("/dressTable")
    public  String customerTable(Model model){
        List<Dress> dress =dressService.allDress();
        model.addAttribute("dress",dress);
        return  "dressTable";
    }


    @GetMapping("/orderDress")
    public  String OrderDress(Principal principal,Model model){

        return "orderDress";
    }

     @GetMapping("/myOrderDress")
     public  String myOrderDress(Principal principal, Model model){
    if(principal!=null){
        String username = principal.getName();
        model.addAttribute("username",username);
    }
    Customer customer = customerService.findByUsername(principal.getName());
    model.addAttribute("orderDress",orderDressService.orderDress(principal.getName()));
    return "myOrderDress";
    }





    @GetMapping("/orderDress/{id}")
    public  String cancelOrder(@PathVariable Long id, Model model, Principal principal){
        if(principal!=null){
            String username = principal.getName();
            model.addAttribute("username",username);
        }
        orderDressService.remove(id);
        return "redirect:/myOrderDress";
    }

}
