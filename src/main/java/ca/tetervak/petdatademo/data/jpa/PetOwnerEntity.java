package ca.tetervak.petdatademo.data.jpa;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pet_owner")
public class PetOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    @Column(name = "first_name")
    private String firstName = "";

    @Column(name = "last_name")
    private String lastName = "";

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<PetEntity> pets = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private ContactEntity contact;

    public PetOwnerEntity() {
    }

    public PetOwnerEntity(
            String firstName,
            String lastName,
            List<PetEntity> pets,
            ContactEntity contact
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
        this.contact = contact;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PetEntity> getPets() {
        return pets;
    }

    public void setPets(List<PetEntity> pets) {
        this.pets = pets;
    }

    @JsonGetter
    Integer getPetCount() {
        return pets.size();
    }
}
