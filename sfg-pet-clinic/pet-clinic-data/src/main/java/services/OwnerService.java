package services;

import doxcom.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner FindById(Long id);
    Owner save(Owner owner);

    Set<Owner> findAll();

}
