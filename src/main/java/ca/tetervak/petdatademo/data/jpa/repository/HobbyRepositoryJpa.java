package ca.tetervak.petdatademo.data.jpa.repository;

import ca.tetervak.petdatademo.data.jpa.entity.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "hobbies",
        collectionResourceRel = "hobbies",
        itemResourceRel = "hobby"
)
public interface HobbyRepositoryJpa extends JpaRepository<HobbyEntity, Integer> {
}
