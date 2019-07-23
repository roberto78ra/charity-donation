package pl.coderslab.charity.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "donation")
public class Donation {
    public Donation(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int quantity;

    @OneToMany(mappedBy = "donation", cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToOne(mappedBy = "donation", cascade = CascadeType.ALL)
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    private Date pickUpDate;

    private Time pickUpTime;

    private String pickUpComment;
}
