package ca.tetervak.petdatademo.data.jpa;

import ca.tetervak.petdatademo.data.PetDataService;
import ca.tetervak.petdatademo.model.Pet;
import ca.tetervak.petdatademo.model.PetDetails;
import ca.tetervak.petdatademo.model.PetOwner;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetDataServiceJpa implements PetDataService {


    private final PetRepositoryJpa repository;

    public PetDataServiceJpa(PetRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public List<Pet> findAllPets() {
        return repository.findAll()
                .stream()
                .map(e -> new Pet(e.getId(), e.getName(), e.getPetKind()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    @Transactional
    public Optional<PetDetails> findPetDetailsById(int id) {
        Optional<PetEntity> optionalPetEntity = repository.findById(id);
        if (optionalPetEntity.isPresent()) {
            PetEntity petEntity = optionalPetEntity.get();
            PetOwnerEntity ownerEntity = petEntity.getOwner();
            PetOwner owner = new PetOwner(
                    ownerEntity.getId(),
                    ownerEntity.getFirstName(),
                    ownerEntity.getLastName(),
                    ownerEntity.getContact().getEmail());
            return Optional.of(
                    new PetDetails(
                            petEntity.getId(),
                            petEntity.getName(),
                            petEntity.getPetKind(),
                            petEntity.getAge(),
                            owner));
        }
        return Optional.empty();
    }
}
