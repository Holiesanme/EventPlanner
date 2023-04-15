package cs.ubbluj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Participant implements Serializable {


    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    Long id;

    String name;
    Boolean priority;
    Integer team;
    Integer rating;
    LocalDateTime created;
    Long roomId;


    public Participant() {
    }

    public Participant(Long id, String name, Boolean priority, Integer team, Integer rating, LocalDateTime created, Long roomId) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.team = team;
        this.rating = rating;
        this.created = created;
        this.roomId = roomId;
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

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", team=" + team +
                ", rating=" + rating +
                ", created=" + created +
                ", roomId=" + roomId +
                '}';
    }

    @PrePersist
    void created() {
        this.created = LocalDateTime.now();
    }
}
