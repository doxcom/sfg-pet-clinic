package services;

import doxcom.springframework.sfgpetclinic.model.Owner;
import doxcom.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet FindById(Long id);
    Pet save(Pet pet);

    Set<Pet> findAll();
}
