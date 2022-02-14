package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.CustomerRepository;
import engineer.chandrakanta.Gallery.Repository.DressRepository;
import engineer.chandrakanta.Gallery.Repository.GalleryRepository;
import engineer.chandrakanta.Gallery.Repository.OrderGalleryRepository;
import engineer.chandrakanta.Gallery.Service.CustomerService;
import engineer.chandrakanta.Gallery.Service.DressService;
import engineer.chandrakanta.Gallery.Service.GalleryService;
import engineer.chandrakanta.Gallery.Service.OrderGalleryService;
import engineer.chandrakanta.Gallery.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class GalleryController {

   @Autowired
    GalleryService galleryService;
   @Autowired
    GalleryRepository galleryRepository;
   @Autowired
    CustomerService customerService;
   @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DressService dressService;
    @Autowired
    DressRepository dressRepository;
    @Autowired
    OrderGalleryService orderGalleryService;
    @Autowired
    OrderGalleryRepository orderGalleryRepository;



    @GetMapping("/womenWear")
    public  String womenWear(Model model){
        model.addAttribute("womenWears",dressService.findByDressType("womenWear"));
        return  "womenWear";
    }

     @GetMapping("/menWear")
     public  String menWear(Model model){
        model.addAttribute("menWears",dressService.findByDressType("menWear"));
      return  "menWear";
    }


    @GetMapping("/gallery")
    public String men(Model model){
        List<Gallery> galleries =galleryService.showsGallery();
        model.addAttribute("galleries",galleries);
        return "gallery";
    }
    @GetMapping("/buyGallery/{id}")
    public String buyNow(@PathVariable Long id, Principal principal, Model model){
        if(principal!=null){
            String username = principal.getName();
            model.addAttribute("username",username);
        }
        Gallery gallery = galleryService.getById(id);
        Customer customer = customerService.findByUsername(principal.getName());
        OrderGallery orderGallery = new OrderGallery();
        orderGallery.setGallery(gallery);
        orderGallery.setCustomer(customer);
         orderGalleryService.addOrderGallery(orderGallery);
        return "buyGallery";
    }

    @GetMapping("/orderGallery")
    public  String buyGallery(Model model,Principal principal){
        return "orderGallery";
    }
    @GetMapping("/myOrderGallery")
    public  String myOrderGallery(Principal principal, Model model){
        if(principal!=null){
            String username = principal.getName();
            model.addAttribute("username",username);
        }
        Customer customer = customerService.findByUsername(principal.getName());
        model.addAttribute("orderGallery",orderGalleryService.orderGallery(principal.getName()));
        return "myOrderGallery";
    }

    @GetMapping("/orderGallery/{id}")
    public  String cancelOrder(@PathVariable Long id, Model model, Principal principal){
        if(principal!=null){
            String username = principal.getName();
            model.addAttribute("username",username);
        }
        orderGalleryService.remove(id);
        return "redirect:/myOrderGallery";
    }
}
