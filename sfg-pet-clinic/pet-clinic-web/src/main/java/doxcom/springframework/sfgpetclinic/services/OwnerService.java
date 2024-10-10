package doxcom.springframework.sfgpetclinic.services;

import doxcom.springframework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


    List<Owner> findAllByLastNameLike(String lastName);

}
