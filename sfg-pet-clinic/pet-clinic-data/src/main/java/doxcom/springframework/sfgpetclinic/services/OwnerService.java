package doxcom.springframework.sfgpetclinic.services;

import doxcom.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
