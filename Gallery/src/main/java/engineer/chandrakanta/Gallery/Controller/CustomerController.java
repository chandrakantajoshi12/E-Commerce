package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.CustomerRepository;
import engineer.chandrakanta.Gallery.Service.CustomerService;
import engineer.chandrakanta.Gallery.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/register")
    public String registration() {
        return "register";
    }

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }
    @GetMapping("/main")
    public  String main(){
        return  "main";
    }




    @GetMapping("/logout")
    public String logoutForm(){
        return "login";
    }



    @PostMapping("/register")
    public String registration(HttpServletRequest request , Model model) {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        Customer customer;
        if(username.equals("admin")) {
          customer = new Customer(username, name, address, emailId, password, "ROLE_ADMIN");
        } else{
             customer= new Customer(username,name,address,emailId,password,"ROLE_USER");
        }
        if(!customerService.existsByUsername(username)) {
            customerService.createCustomer(customer);
        } else{
            model.addAttribute("message","Choose Correct Username");
        }

        return "redirect:/login";

    }

    @GetMapping("/success")
    public String login(Principal principle) {
        String username = principle.getName();

       if (username.equals("admin")) {
           return "redirect:/addContain";
        }
        return "redirect:/main";
    }


     @GetMapping("/customerTable")
    public  String customerTable(Model model){
        List<Customer> cust =customerService.showsDetails();
       model.addAttribute("customers",cust);
        return  "customerTable";
     }


     @GetMapping("/updateCustomer")
     public String updateCustomer(Model model){
//        model.addAttribute("message","Profile Updated");
        return "updateCustomer";
     }

     @PutMapping("/updateCustomer")
      public  String  updateCustomer(HttpServletRequest request , Model model){
      String name = request.getParameter("name");
      String address = request.getParameter("address");
      String emailId = request.getParameter("emailId");
      String password = request.getParameter("password");
      Customer customer = new Customer  (name,address,emailId,password);
      customerService.updateCustomer(customer);
         model.addAttribute("message","Profile Updated");
      return "updateCustomer";
     }
     //view Profile
    @GetMapping("/profile")
    public  String profile(Principal principal, Model model){
        if(principal!=null){
            String username = principal.getName();
            Customer customer = customerService.findByUsername(username);
            model.addAttribute("username",customer.getName());
        }
        model.addAttribute("customer",customerService.findByUsername(principal.getName()));
        return  "profile";
    }

}

