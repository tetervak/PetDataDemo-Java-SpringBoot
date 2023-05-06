package ca.tetervak.petdatademo.data.jpa;

import ca.tetervak.petdatademo.data.jpa.entity.ContactEntity;
import ca.tetervak.petdatademo.data.jpa.entity.HobbyEntity;
import ca.tetervak.petdatademo.data.jpa.entity.PetEntity;
import ca.tetervak.petdatademo.data.jpa.entity.PetOwnerEntity;
import ca.tetervak.petdatademo.data.jpa.repository.HobbyRepositoryJpa;
import ca.tetervak.petdatademo.data.jpa.repository.PetOwnerRepositoryJpa;
import ca.tetervak.petdatademo.model.PetKind;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataInitializerJpa {

    private final PetOwnerRepositoryJpa userRepository;
    private final HobbyRepositoryJpa hobbyRepositoryJpa;

    public DataInitializerJpa(PetOwnerRepositoryJpa userRepository, HobbyRepositoryJpa hobbyRepositoryJpa) {
        this.userRepository = userRepository;
        this.hobbyRepositoryJpa = hobbyRepositoryJpa;
    }

    @PostConstruct
    public void init(){

        // All pet hobbies

        HobbyEntity slippers = new HobbyEntity("Bringing slippers to humans.");
        slippers = hobbyRepositoryJpa.save(slippers);

        HobbyEntity squirrels = new HobbyEntity("Chasing squirrels on the backyard.");
        squirrels = hobbyRepositoryJpa.save(squirrels);

        HobbyEntity aquarium = new HobbyEntity("Watching fish in the aquarium.");
        aquarium = hobbyRepositoryJpa.save(aquarium);

        HobbyEntity sleeping = new HobbyEntity("Having an afternoon nap.");
        sleeping = hobbyRepositoryJpa.save(sleeping);

        HobbyEntity fetch = new HobbyEntity("Playing fetch with tennis balls.");
        fetch = hobbyRepositoryJpa.save(fetch);

        HobbyEntity eating = new HobbyEntity("Getting a yummy treat.");
        eating = hobbyRepositoryJpa.save(eating);

        HobbyEntity whistle = new HobbyEntity("Whistling \"My heart will go on\" from Titanic.");
        whistle = hobbyRepositoryJpa.save(whistle);

        HobbyEntity running = new HobbyEntity("Running on the wheel.");
        running = hobbyRepositoryJpa.save(running);

        // Patricia and her pets

        PetOwnerEntity patricia = new PetOwnerEntity(
                "Patricia", "Johnson",
                new ContactEntity("pat.johnson@gmail.com", "905-459-7533"));

        PetEntity charlie = new PetEntity("Charlie", PetKind.DOG, 3);
        charlie.addHobby(slippers);
        charlie.addHobby(sleeping);
        charlie.addHobby(fetch);
        patricia.addPet(charlie);

        PetEntity fluffy = new PetEntity("Fluffy", PetKind.CAT, 2);
        fluffy.addHobby(aquarium);
        fluffy.addHobby(sleeping);
        patricia.addPet(fluffy);

        userRepository.save(patricia);

        // Lisa and her pets

        PetOwnerEntity lisa = new PetOwnerEntity(
                "Lisa", "Anderson",
                new ContactEntity("lisa.anderson@gmail.com", "905-845-9430"));

        PetEntity oscar = new PetEntity("Oscar", PetKind.CAT, 6);
        oscar.addHobby(sleeping);
        oscar.addHobby(squirrels);

        userRepository.save(lisa);

        // Kimberly without pets

        PetOwnerEntity kimberly = new PetOwnerEntity(
                "Kimberly", "Green",
                new ContactEntity("green@sheridancollege.ca", "905-845-9430"));
        userRepository.save(kimberly);

        // Brenda and her pets

        PetOwnerEntity brenda = new PetOwnerEntity(
                "Brenda", "Clark",
                new ContactEntity("brenda_clark@hotmail.com", "905-845-9430"));

        PetEntity max = new PetEntity("Max", PetKind.BIRD, 10);
        max.addHobby(whistle);
        max.addHobby(eating);
        brenda.addPet(max);

        PetEntity riley = new PetEntity("Riley", PetKind.CAT, 5);
        riley.addHobby(sleeping);
        brenda.addPet(riley);

        brenda.addPet(new PetEntity("Sam", PetKind.RABBIT, 2));

        PetEntity milo = new PetEntity("Milo", PetKind.HAMSTER, 1);
        milo.addHobby(running);
        milo.addHobby(eating);
        milo.addHobby(sleeping);

        brenda.addPet(milo);

        userRepository.save(brenda);

        userRepository.flush();
    }
}
