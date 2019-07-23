package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

    @OneToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;
}
