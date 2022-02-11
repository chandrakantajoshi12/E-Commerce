package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.CustomerRepository;
import engineer.chandrakanta.Gallery.Repository.GalleryRepository;
import engineer.chandrakanta.Gallery.Service.CustomerService;
import engineer.chandrakanta.Gallery.Service.GalleryService;
import engineer.chandrakanta.Gallery.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
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

//
//    @GetMapping("/women")
//    public  String women(Model model){
//        List<WomenWear> womenWears= womenWearService.showDetails();
//        model.addAttribute("womenWears",womenWears);
//        return  "women";
//    }


    @GetMapping("/gallery")
    public String men(Model model){
        List<Gallery> galleries =galleryService.showsGallery();
        model.addAttribute("galleries",galleries);
        return "gallery";
    }
//    @GetMapping("{userName}/buyNow/{id}")
//    public String buyNow(@PathVariable Long id, @PathVariable  String userName, Model model){
////        model.addAttribute("gallery",galleryService.getById(id) );
//        Gallery gallery = galleryService.getById(id);
//        Customer customer = customerService.findByUsername(userName);
//        Order order = new Order();
//        order.setGallery(gallery);
//        order.setCustomer(customer);
//
//        return "buyNow";
//    }
    @PostMapping("/orderSuccess")
    public  String buyNow(HttpServletRequest request){
        String name = request.getParameter("name");
        String emailId = request.getParameter("emailId");
        String address= request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String  zip = request.getParameter("zip");
        String cardName = request.getParameter("cardName");
        String month = request.getParameter("month");
        String year = request .getParameter("year");
        Integer cvv = Integer.parseInt(request.getParameter("cvv"));

          Order order = new Order();

         return "orderSuccess";
    }
}
