package ca.tetervak.petdatademo.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepositoryJpa extends JpaRepository<PetEntity, Integer> {
}
