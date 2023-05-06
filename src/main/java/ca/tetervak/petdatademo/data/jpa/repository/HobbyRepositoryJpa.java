package ca.tetervak.petdatademo.data.jpa.repository;

import ca.tetervak.petdatademo.data.jpa.entity.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepositoryJpa extends JpaRepository<HobbyEntity, Integer> {
}
