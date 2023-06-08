package ca.tetervak.petdatademo.data.jpa.repository;

import ca.tetervak.petdatademo.data.jpa.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(
        path = "pets",
        collectionResourceRel = "pets",
        itemResourceRel = "pet"
)
public interface PetRepositoryJpa extends JpaRepository<PetEntity, Integer> {
}
