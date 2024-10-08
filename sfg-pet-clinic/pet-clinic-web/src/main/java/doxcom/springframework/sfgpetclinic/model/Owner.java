package doxcom.springframework.sfgpetclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder //the build will generate all these values, first 3 properties come from Person Class
    public Owner( Long id, String firstName,  String lastName, Set<Pet> pets, String telephone, String city, String address) {
        super(id,firstName,lastName);
        this.pets = pets;
        this.telephone = telephone;
        this.city = city;
        this.address = address;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //if a delete an owner the pet also will be deleted
    private Set<Pet> pets = new HashSet<>();


}
