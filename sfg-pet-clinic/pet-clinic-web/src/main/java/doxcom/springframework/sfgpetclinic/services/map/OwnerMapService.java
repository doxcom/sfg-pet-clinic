package doxcom.springframework.sfgpetclinic.services.map;

import doxcom.springframework.sfgpetclinic.model.Owner;
import doxcom.springframework.sfgpetclinic.model.Pet;
import doxcom.springframework.sfgpetclinic.services.PetService;
import doxcom.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import doxcom.springframework.sfgpetclinic.services.OwnerService;

import java.util.List;
import java.util.Set;
@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    //Owners of the Pets

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        Owner savedOwner = null;
        if (object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){ //if petType is not assigned
                            pet.setPetType(petTypeService.save(pet.getPetType())); //take the pet from the pet service
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId()==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public void delete(Owner object) {

        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
     super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner ->owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);


    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        //todo - impl
        return null;
    }
}
