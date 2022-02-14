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
        OrderGallery order = new OrderGallery();
//        order.setGallery(gallery);
//        order.setCustomer(customer);

        return "buyGallery";
    }
//     @GetMapping("/orderGallery")
//     public  String buyGallery(){
//        return  "orderGallery";
//     }

    @GetMapping("/orderGallery")
    public  String buyGallery(){
//        String name = request.getParameter("name");
//        String emailId = request.getParameter("emailId");
//        String address= request.getParameter("address");
//        String city = request.getParameter("city");
//        String state = request.getParameter("state");
//        String  zip = request.getParameter("zip");
//        String cardName = request.getParameter("cardName");
//        String month = request.getParameter("month");
//        String year = request .getParameter("year");
//        Integer cvv = Integer.parseInt(request.getParameter("cvv"));
//
//          Order order = new Order();

         return "orderGallery";
    }
    @GetMapping("/myOrderGallery")
    public  String myOrderDress(Principal principal,Model model){
        if(principal!=null){
            String username = principal.getName();
            model.addAttribute("username",username);
        }
//        Customer customer = customerService.getByUsername(principal.getName());
        model.addAttribute("orderGallery",orderGalleryService.orderGallery(principal.getName()));
//        model.addAttribute("orders",orderDressService.addOrder());
        return "myOrderGallery";
    }
}
