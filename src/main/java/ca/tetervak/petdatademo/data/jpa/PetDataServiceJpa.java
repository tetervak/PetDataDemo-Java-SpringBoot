package ca.tetervak.petdatademo.data.jpa;

import ca.tetervak.petdatademo.data.PetDataService;
import ca.tetervak.petdatademo.data.jpa.entity.HobbyEntity;
import ca.tetervak.petdatademo.data.jpa.entity.PetEntity;
import ca.tetervak.petdatademo.data.jpa.entity.PetOwnerEntity;
import ca.tetervak.petdatademo.data.jpa.repository.PetRepositoryJpa;
import ca.tetervak.petdatademo.model.Pet;
import ca.tetervak.petdatademo.model.PetDetails;
import ca.tetervak.petdatademo.model.PetOwner;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetDataServiceJpa implements PetDataService {

    private final Logger log = LoggerFactory.getLogger(PetDataServiceJpa.class);
    private final PetRepositoryJpa repository;

    public PetDataServiceJpa(PetRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public List<Pet> findAllPets() {
        log.trace("findAllPets() is called.");
        return repository.findAll()
                .stream()
                .map(e -> new Pet(e.getId(), e.getName(), e.getPetKind()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    @Transactional
    public Optional<PetDetails> findPetDetailsById(int id) {
        log.trace("findPetDetailsById() is called.");
        log.debug("id=" + id);
        Optional<PetEntity> optionalPetEntity = repository.findById(id);
        if (optionalPetEntity.isPresent()) {
            PetEntity petEntity = optionalPetEntity.get();
            PetOwnerEntity ownerEntity = petEntity.getOwner();
            PetOwner owner = new PetOwner(
                    ownerEntity.getId(),
                    ownerEntity.getFirstName(),
                    ownerEntity.getLastName(),
                    ownerEntity.getContact().getEmail());
            List<String> hobbies = petEntity.getHobbies()
                    .stream()
                    .map(HobbyEntity::getDescription)
                    .collect(Collectors.toCollection(ArrayList::new));
            return Optional.of(
                    new PetDetails(
                            petEntity.getId(),
                            petEntity.getName(),
                            petEntity.getPetKind(),
                            petEntity.getAge(),
                            owner,
                            hobbies));
        }
        return Optional.empty();
    }
}
