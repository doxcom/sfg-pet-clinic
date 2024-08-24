package doxcom.springframework.sfgpetclinic.bootstrap;

import doxcom.springframework.sfgpetclinic.model.Owner;
import doxcom.springframework.sfgpetclinic.model.Pet;
import doxcom.springframework.sfgpetclinic.model.PetType;
import doxcom.springframework.sfgpetclinic.model.Vet;
import doxcom.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import doxcom.springframework.sfgpetclinic.services.OwnerService;
import doxcom.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Daria");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Milo");
        PetType savedDogPetType = petTypeService.save(dog);


        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("West");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("55555555");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate( LocalDate.now());
        mikesPet.setName("Bosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennson");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("55555555");

       // Pet fionasCat = new Pet();
      //  fionasCat



        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Alice");
        owner3.setLastName("Cops");

        ownerService.save(owner3);

        System.out.println("loading Owners...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Maxim");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Miko");
        vet2.setLastName("Nap");
        vetService.save(vet2);


        System.out.println("loading vets...");



    }
}
