package doxcom.springframework.sfgpetclinic.bootstrap;


import doxcom.springframework.sfgpetclinic.model.Owner;
import doxcom.springframework.sfgpetclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import doxcom.springframework.sfgpetclinic.services.OwnerService;
import doxcom.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("West");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mike");
        owner1.setLastName("Wasaus");

        ownerService.save(owner2);

        System.out.println("loading Owners...");


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Brune");
        vet1.setLastName("Sante");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Daxi");
        vet1.setLastName("Liump");

        vetService.save(vet2);

        System.out.println("loading vets...");



    }
}
