package cs.ubbluj.model;


import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    public Room() {}

    public Room(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
