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
}
