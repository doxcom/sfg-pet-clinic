package doxcom.springframework.sfgpetclinic.repositories;

import doxcom.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
