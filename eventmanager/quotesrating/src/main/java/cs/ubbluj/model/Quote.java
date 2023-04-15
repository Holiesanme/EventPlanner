package cs.ubbluj.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Quote {


    @Id
    Long id;
    String value;

    Integer rating;

    public Quote() {
    }

    public Quote(Long id, String value, Integer rating) {
        this.id = id;
        this.value = value;
        this.rating = rating;
    }

    public Quote(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", rating=" + rating +
                '}';
    }
}
