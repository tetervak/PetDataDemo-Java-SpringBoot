package ca.tetervak.petdatademo.model;

import java.util.Collections;
import java.util.List;

public record PetDetails(Integer id, String name, PetKind petKind, Integer age, PetOwner owner, List<String> hobbies) {
    public PetDetails(Integer id, String name, PetKind petKind, Integer age, PetOwner owner, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.petKind = petKind;
        this.age = age;
        this.owner = owner;
        this.hobbies = Collections.unmodifiableList(hobbies);
    }
}
