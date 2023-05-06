package ca.tetervak.petdatademo.data.jpa;

import ca.tetervak.petdatademo.model.PetKind;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataInitializer {

    private final PetOwnerRepositoryJpa userRepository;

    public DataInitializer(PetOwnerRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){

        List<PetEntity> patriciaPets = new ArrayList<>(2);
        PetOwnerEntity patricia = new PetOwnerEntity(
                "Patricia", "Johnson",
                patriciaPets,
                new ContactEntity("pat.johnson@gmail.com", "905-459-7533"));
        patriciaPets.add(new PetEntity("Charlie", PetKind.DOG, 3, patricia));
        patriciaPets.add(new PetEntity("Fluffy", PetKind.CAT, 2, patricia));
        userRepository.save(patricia);

        List<PetEntity> lisaPets = new ArrayList<>(1);
        PetOwnerEntity lisa = new PetOwnerEntity(
                "Lisa", "Anderson",
                lisaPets,
                new ContactEntity("lisa.anderson@gmail.com", "905-845-9430"));
        lisaPets.add(new PetEntity("Oscar", PetKind.CAT, 6, lisa));
        userRepository.save(lisa);

        PetOwnerEntity kimberly = new PetOwnerEntity(
                "Kimberly", "Green",
                new ArrayList<>(0),
                new ContactEntity("green@sheridancollege.ca", "905-845-9430"));
        userRepository.save(kimberly);

        List<PetEntity> brendaPets = new ArrayList<>(4);
        PetOwnerEntity brenda = new PetOwnerEntity(
                "Brenda", "Clark",
                brendaPets,
                new ContactEntity("brenda_clark@hotmail.com", "905-845-9430"));
        brendaPets.add(new PetEntity("Max", PetKind.BIRD, 10, brenda));
        brendaPets.add(new PetEntity("Riley", PetKind.CAT, 5, brenda));
        brendaPets.add(new PetEntity("Sam", PetKind.RABBIT, 2, brenda));
        brendaPets.add(new PetEntity("Milo", PetKind.HAMSTER, 1, brenda));

        userRepository.save(brenda);

        userRepository.flush();
    }
}
