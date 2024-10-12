package doxcom.springframework.sfgpetclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder //the build will generate all these values, first 3 properties come from Person Class
    public Owner( Long id, String firstName,  String lastName, String telephone, String city, String address, Set<Pet> pets) {
        super(id,firstName,lastName);
        this.telephone = telephone;
        this.city = city;
        this.address = address;

        if (pets != null) {
            this.pets = pets;
        }
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //if a delete an owner the pet also will be deleted
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(String name){
        return  getPet(name,false);
    }

    public Pet getPet(String name, boolean ignoreNew){
        name = name.toLowerCase();
        for(Pet pet : pets){
            if(!ignoreNew || !pet.isNew()){
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if(compName.equals(name)){
                    return pet;
                }
            }

        }
        return null;
    }


}
