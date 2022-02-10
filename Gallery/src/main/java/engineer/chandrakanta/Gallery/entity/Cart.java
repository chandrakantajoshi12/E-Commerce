package engineer.chandrakanta.Gallery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart{
    @Id
    @GeneratedValue
    private Long id;
     @JsonIgnore
     @ManyToOne
     private  Customer customer;

     @JsonIgnore
     @ManyToOne
     private MenWear menWear;

     @JsonIgnore
     @ManyToOne
     private  WomenWear womenWear;

    @JsonIgnore
    @ManyToOne
    private  Gallery gallery;

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }


//     @JsonIgnore

    public WomenWear getWomenWear() {
        return womenWear;
    }

    public void setWomenWear(WomenWear womenWear) {
        this.womenWear = womenWear;
    }



    public MenWear getMenWear() {
        return menWear;
    }

    public void setMenWear(MenWear menWear) {
        this.menWear = menWear;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public  Cart(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
