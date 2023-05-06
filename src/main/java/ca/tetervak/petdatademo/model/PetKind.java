package ca.tetervak.petdatademo.model;

public enum PetKind {
    CAT, DOG, RABBIT, HAMSTER, BIRD, OTHER;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
