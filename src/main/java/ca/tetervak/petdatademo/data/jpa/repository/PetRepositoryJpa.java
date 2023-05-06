package ca.tetervak.petdatademo.data.jpa.repository;

import ca.tetervak.petdatademo.data.jpa.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepositoryJpa extends JpaRepository<PetEntity, Integer> {
}
