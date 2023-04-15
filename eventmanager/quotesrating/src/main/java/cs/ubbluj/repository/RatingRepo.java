package cs.ubbluj.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import cs.ubbluj.model.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long> {

}
