package engineer.chandrakanta.Gallery.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String username;
    private  String name;
    private  String address;
    private  String emailId;
    private  String role;
    @Column(unique = true)
    private String password;


    @OneToMany(mappedBy = "customer")
    private  List<Order> order;

    @OneToMany(mappedBy = "customer")
    private  List<Dress> dress;


    public Customer(String username, String name, String address, String emailId, String password, String role) {
     this.username=username;
     this.name=name;
     this.address=address;
     this.emailId=emailId;
     this.password=password;
     this.role=role;

     }

    public Customer(String username, String name, String address, String password, String role_user) {
    }

    public Customer(String name, String address, String emailId, String password) {
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Dress> getDress() {
        return dress;
    }

    public void setDress(List<Dress> dress) {
        this.dress = dress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
//
//    @OneToMany(mappedBy = "customer")
//     private  List<Cart> cart;

  public Customer(){}





    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
