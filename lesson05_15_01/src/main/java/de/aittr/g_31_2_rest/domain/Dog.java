package de.aittr.g_31_2_rest.domain;

import java.util.Objects;

public class Dog {

    private int id;
    private String name;
    private double weight;
    private String breed;

    public Dog() {
    }

    public Dog(String name, double weight, String breed) {
        this.name = name;
        this.weight = weight;
        this.breed = breed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && Double.compare(dog.weight, weight) == 0 && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, breed);
    }

    @Override
    public String toString() {
        return String.format("Dog: id - %d, name - %s, weight - %.3f, breed - %s", id, name, weight, breed);
    }
}
