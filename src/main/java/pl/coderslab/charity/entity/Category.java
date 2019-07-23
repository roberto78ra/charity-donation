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




}
