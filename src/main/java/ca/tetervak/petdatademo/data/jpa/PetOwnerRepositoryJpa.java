package ca.tetervak.petdatademo.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepositoryJpa extends JpaRepository<PetOwnerEntity, Integer> {
}
