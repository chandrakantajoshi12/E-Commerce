package engineer.chandrakanta.Gallery.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gallery {
    @Id
    private  Long id;
    private  String brand;
    private String name;
    private  Double cost;
    private  String photo;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public  Gallery(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {

        this.photo = photo;
    }

    public Gallery(Long id, String brand, String name,Double cost,String photo) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.cost=cost;
        this.photo = photo;

    }

}
