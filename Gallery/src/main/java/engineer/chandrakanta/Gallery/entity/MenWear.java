package engineer.chandrakanta.Gallery.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenWear {
    @Id
    private  Long id;
    private  String brand;
    private String dressName;
    private  Double cost;
    private  String snapShot;
    private String dressType;

    public MenWear(Long id, String brand, String dressName, Double cost, String snapShot) {
    }

    public String getDressType() {
        return dressType;
    }

    public void setDressType(String dressType) {
        this.dressType = dressType;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


    public String getSnapShot() {
        return snapShot;
    }

    public void setSnapShot(String snapShot) {
        this.snapShot = snapShot;
    }

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

    public String getDressName() {
        return dressName;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
    }



    public MenWear(){}

    public MenWear(Long id, String brand, String dressName, Double cost, String snapShot ,String type) {
        this.id = id;
        this.brand = brand;
        this.dressName = dressName;
        this.cost= cost;
        this.snapShot = snapShot;
        this.dressType=type;

    }
}
