package ca.tetervak.petdatademo.data.jpa.repository;

import ca.tetervak.petdatademo.data.jpa.entity.PetOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepositoryJpa extends JpaRepository<PetOwnerEntity, Integer> {
}
