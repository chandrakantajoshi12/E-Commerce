package engineer.chandrakanta.Gallery.Service;


import engineer.chandrakanta.Gallery.entity.Customer;
import engineer.chandrakanta.Gallery.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private  CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Customer user = customerService.findByUsername(username);
           return new MyUserDetails(user);
    }


//AdminLogin findByUsername(String username);
}
