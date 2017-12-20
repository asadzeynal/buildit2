package az.pkg.buildit.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PlantHireRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String contact;
    private double cost;
    private Date endr;
    private Date start;
    @OneToOne
    private Plant plant;
    @OneToOne
    private User user;
    private PlantHireRequestStatus status;

    public PlantHireRequestStatus getStatus() {
        return status;
    }

    public void setStatus(PlantHireRequestStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getEndr() {
        return endr;
    }

    public void setEndr(Date endr) {
        this.endr = endr;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}