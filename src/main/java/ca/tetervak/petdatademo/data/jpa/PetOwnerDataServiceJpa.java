package ca.tetervak.petdatademo.data.jpa;

import ca.tetervak.petdatademo.data.PetOwnerDataService;
import ca.tetervak.petdatademo.model.Pet;
import ca.tetervak.petdatademo.model.PetOwner;
import ca.tetervak.petdatademo.model.PetOwnerDetails;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetOwnerDataServiceJpa implements PetOwnerDataService {

    private final PetOwnerRepositoryJpa repository;

    public PetOwnerDataServiceJpa(PetOwnerRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public List<PetOwner> findAllPetOwners() {
        return repository.findAll()
                .stream()
                .map(e -> new PetOwner(
                        e.getId(),
                        e.getFirstName(),
                        e.getLastName(),
                        e.getContact().getEmail()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    @Transactional
    public Optional<PetOwnerDetails> findPetOwnerDetailsById(int id) {
        Optional<PetOwnerEntity> optionalPetOwnerEntity = repository.findById(id);
        if (optionalPetOwnerEntity.isPresent()) {
            PetOwnerEntity petOwnerEntity = optionalPetOwnerEntity.get();
            List<Pet> pets = petOwnerEntity.getPets()
                    .stream()
                    .map(e -> new Pet(e.getId(), e.getName(), e.getPetKind()))
                    .collect(Collectors.toCollection(ArrayList::new));
            return Optional.of(
                    new PetOwnerDetails(
                            petOwnerEntity.getId(),
                            petOwnerEntity.getFirstName(),
                            petOwnerEntity.getLastName(),
                            petOwnerEntity.getContact().getEmail(),
                            petOwnerEntity.getContact().getPhone(),
                            pets));
        }
        return Optional.empty();
    }
}
