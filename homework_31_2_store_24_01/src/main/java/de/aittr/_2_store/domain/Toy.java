package de.aittr._2_store.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "toy")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "allowedAge")
    private String allowedAge;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAllowedAge() {
        return allowedAge;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAllowedAge(String allowedAge) {
        this.allowedAge = allowedAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id && Objects.equals(title, toy.title) && Objects.equals(allowedAge, toy.allowedAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, allowedAge);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", allowedAge='" + allowedAge + '\'' +
                '}';
    }
}
