package ca.tetervak.petdatademo.data.jpa;

import ca.tetervak.petdatademo.model.PetKind;
import jakarta.persistence.*;

@Entity
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = null;

    private String name = "";

    @Column(name = "pet_kind")
    @Enumerated(EnumType.STRING)
    private PetKind petKind = PetKind.OTHER;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private PetOwnerEntity owner;


    public PetEntity(String name, PetKind petKind, Integer age, PetOwnerEntity owner) {
        this.name = name;
        this.petKind = petKind;
        this.age = age;
        this.owner = owner;
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
