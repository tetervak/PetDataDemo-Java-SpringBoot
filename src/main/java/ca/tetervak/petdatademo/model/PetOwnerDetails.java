package ca.tetervak.petdatademo.model;

import java.util.List;


public class PetOwnerDetails {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final List<Pet> pets;

    public PetOwnerDetails(
            Integer id,
            String firstName,
            String lastName,
            String email,
            String phone,
            List<Pet> pets
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pets = pets;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "PetOwnerDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pets=" + pets +
                '}';
    }
}
