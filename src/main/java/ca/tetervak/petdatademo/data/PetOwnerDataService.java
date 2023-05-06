package ca.tetervak.petdatademo.data;

import ca.tetervak.petdatademo.model.PetOwner;
import ca.tetervak.petdatademo.model.PetOwnerDetails;

import java.util.List;
import java.util.Optional;

public interface PetOwnerDataService {

    List<PetOwner> findAllPetOwners();

    Optional<PetOwnerDetails> findPetOwnerDetailsById(int id);
}
