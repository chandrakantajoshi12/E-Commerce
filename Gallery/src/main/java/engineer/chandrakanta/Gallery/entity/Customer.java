package engineer.chandrakanta.Gallery.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
    @Id
    private String userName;
    private  String name;
    private  String address;
    private  String emailId;
    @Column(unique = true)
    private String password;

    public Customer() {

    }




    public Customer(String userName, String name, String address, String emailId, String password) {
        this.userName = userName;
        this.name = name;
        this.address = address;
        this.emailId = emailId;
        this.password = password;
    }
    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
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
