package doxcom.springframework.sfgpetclinic.bootstrap;

import doxcom.springframework.sfgpetclinic.model.*;
import doxcom.springframework.sfgpetclinic.services.PetTypeService;
import doxcom.springframework.sfgpetclinic.services.SpecialtyService;
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
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
       int count = petTypeService.findAll().size();

       if(count == 0){
           loadData();
       }

    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Daria");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Milo");
        PetType savedDogPetType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


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

        Pet fionasCat = new Pet();
        fionasCat.setName("Titi");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate( LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);


        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Alice");
        owner3.setLastName("Cops");

        ownerService.save(owner3);

        System.out.println("loading Owners...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Sam");
        vet1.setLastName("Maxim");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();

        vet2.setFirstName("Orving");
        vet2.setLastName("Nap");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("loading vets...");
    }
}
