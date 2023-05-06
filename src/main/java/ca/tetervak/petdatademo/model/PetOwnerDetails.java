package ca.tetervak.petdatademo.model;

import java.util.List;

public record PetOwnerDetails(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String phone,
        List<Pet> pets
) {
}
