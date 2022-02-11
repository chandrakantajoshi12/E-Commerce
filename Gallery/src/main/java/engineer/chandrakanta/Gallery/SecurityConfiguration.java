package engineer.chandrakanta.Gallery;

import engineer.chandrakanta.Gallery.Service.MyUserDetailService;
import engineer.chandrakanta.Gallery.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

 @EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Override
     protected  void  configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailService);
    }
    @Override

    protected  void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                . authorizeRequests()
                .antMatchers("/addContain").hasRole("Admin")
                .antMatchers("/").hasAnyRole("Admin","User")
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/login");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}