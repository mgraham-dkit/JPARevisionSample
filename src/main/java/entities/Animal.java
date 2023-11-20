package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 20, nullable = false)
    private String type;

    @Column(length = 25, nullable = true)
    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate dob;

    public Animal() {
    }

    public Animal(int id, String type, String name, LocalDate dob) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.dob = dob;
    }

    public Animal(String type, String name, LocalDate dob) {
        this.type = type;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
