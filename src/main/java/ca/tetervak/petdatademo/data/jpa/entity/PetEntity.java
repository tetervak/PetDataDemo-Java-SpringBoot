package ca.tetervak.petdatademo.data.jpa.entity;

import ca.tetervak.petdatademo.model.PetKind;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id = null;

    private String name = "";

    @Column(name = "pet_kind")
    @Enumerated(EnumType.STRING)
    private PetKind petKind = PetKind.OTHER;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private PetOwnerEntity owner;

    @ManyToMany
    @JoinTable(name = "pet_hobbies",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private Set<HobbyEntity> hobbies = new LinkedHashSet<>();

    public Set<HobbyEntity> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyEntity> hobbies) {
        this.hobbies = hobbies;
    }

    public boolean addHobby(HobbyEntity hobby){
        return hobbies.add(hobby);
    }

    public PetEntity(String name, PetKind petKind, Integer age) {
        this.name = name;
        this.petKind = petKind;
        this.age = age;
    }

    public PetEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetKind getPetKind() {
        return petKind;
    }

    public void setPetKind(PetKind petKind) {
        this.petKind = petKind;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PetOwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(PetOwnerEntity owner) {
        this.owner = owner;
    }
}
