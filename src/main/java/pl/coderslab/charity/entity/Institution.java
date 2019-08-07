package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "institution")
public class Institution {

    public Institution() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    @OneToMany(mappedBy = "institution")
    private List<Donation> donationList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Donation> getDonationList() {
        return donationList;
    }

    public void setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
    }
}
