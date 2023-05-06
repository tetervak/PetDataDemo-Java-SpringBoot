package ca.tetervak.petdatademo.data;

import ca.tetervak.petdatademo.model.Pet;
import ca.tetervak.petdatademo.model.PetDetails;

import java.util.List;
import java.util.Optional;

public interface PetDataService {

    List<Pet> findAllPets();

    Optional<PetDetails> findPetDetailsById(int id);
}
