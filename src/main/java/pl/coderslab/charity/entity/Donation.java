package pl.coderslab.charity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;
}
