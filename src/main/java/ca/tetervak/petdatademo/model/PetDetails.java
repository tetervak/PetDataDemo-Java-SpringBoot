package ca.tetervak.petdatademo.model;

/**
 * A DTO for the {@link ca.tetervak.petdatademo.data.jpa.PetEntity} entity
 */
public class PetDetails {
    private final Integer id;
    private final String name;
    private final PetKind petKind;
    private final Integer age;
    private final PetOwner owner;

    public PetDetails(Integer id, String name, PetKind petKind, Integer age, PetOwner owner) {
        this.id = id;
        this.name = name;
        this.petKind = petKind;
        this.age = age;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PetKind getPetKind() {
        return petKind;
    }

    public Integer getAge() {
        return age;
    }

    public PetOwner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "PetDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petKind=" + petKind +
                ", age=" + age +
                ", owner=" + owner +
                '}';
    }
}
