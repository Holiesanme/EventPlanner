package cs.ubbluj.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    Long quoteid;

    Integer rating;

    public Rating() {
    }

    public Rating(Long quoteid, Integer rating) {
        this.quoteid = quoteid;
        this.rating = rating;
    }

    public Long getQuote() {
        return quoteid;
    }

    public void setQuote(Long quote) {
        this.quoteid = quote;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "value='" + quoteid + '\'' +
                ", rating=" + rating +
                '}';
    }
}
