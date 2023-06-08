package ca.tetervak.petdatademo.data.jpa.repository;

import ca.tetervak.petdatademo.data.jpa.entity.PetOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "owners",
        collectionResourceRel = "owners",
        itemResourceRel = "owner"
)
public interface PetOwnerRepositoryJpa extends JpaRepository<PetOwnerEntity, Integer> {
}
