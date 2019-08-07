package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "category")
public class Category {

    public Category() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name="donation_id")
    private Donation donation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }
}
