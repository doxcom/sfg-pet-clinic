package doxcom.springframework.sfgpetclinic.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    @Builder
    public PetType(Long id,String name){
        super(id);
        this.name = name;
    }

    @Column(name ="name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
