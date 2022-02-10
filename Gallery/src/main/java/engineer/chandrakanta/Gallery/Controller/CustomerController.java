package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.CustomerRepository;
import engineer.chandrakanta.Gallery.Service.CustomerService;
import engineer.chandrakanta.Gallery.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


    @GetMapping("/man")
    public  String manWear(){
        return  "men";
    }
    @GetMapping("/logout")
    public String logoutForm(){
        return "login";
    }



    @PostMapping("/login")
    public String registration(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        Customer customer = new Customer(userName, name, address, emailId, password);
        customerService.createCustomer(customer);
        return "login";

    }

    @PostMapping("/main")
    public String main(HttpServletRequest request, Model model) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Customer customer;
        if (customerService.existsByUsername(userName)) {
            customer = customerService.findByUsername(userName);
            if (password.equals(customer.getPassword())) {
                model.addAttribute("message", "Login Successfully");
            } else {
                model.addAttribute("message", "Invalid Password");
                return "login";
            }
        } else {
            model.addAttribute("message", "Please Enter valid Username");
            return "login";
        }

        return "main";
    }
     @GetMapping("/customerTable")
    public  String customerTable(Model model){
        List<Customer> cust =customerService.showsDetails();
       model.addAttribute("customers",cust);
        return  "customerTable";
     }


     @GetMapping("/updateCustomer")
     public String updateCustomer(Model model){
        model.addAttribute("message","Profile Updated");
        return "updateCustomer";
     }

     @PutMapping("/updateCustomer")
      public  String  updateCustomer(HttpServletRequest request , Model model){
      String name = request.getParameter("name");
      String address = request.getParameter("address");
      String emailId = request.getParameter("emailId");
      String password = request.getParameter("password");
      Customer customer = new Customer(name,address,emailId,password);
      customerService.updateCustomer(customer);
//      model.addAttribute("message","Profile Updated");
      return "updateCustomer";
     }


}

