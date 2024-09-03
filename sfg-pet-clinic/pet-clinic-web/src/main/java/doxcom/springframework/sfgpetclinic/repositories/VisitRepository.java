package doxcom.springframework.sfgpetclinic.repositories;

import doxcom.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
