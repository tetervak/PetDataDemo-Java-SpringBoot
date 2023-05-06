package ca.tetervak.petdatademo.model;

public class Pet {
    private final int id;
    private final String name;
    private final PetKind petKind;

    public Pet(int id, String name, PetKind petKind) {
        this.id = id;
        this.name = name;
        this.petKind = petKind;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PetKind getPetKind() {
        return petKind;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petKind=" + petKind +
                '}';
    }
}
