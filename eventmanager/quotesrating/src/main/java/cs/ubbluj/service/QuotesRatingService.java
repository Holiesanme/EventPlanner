package cs.ubbluj.service;

import cs.ubbluj.repository.RatingRepo;
import org.springframework.stereotype.Service;
import cs.ubbluj.model.Rating;

@Service
public class QuotesRatingService {

    private final RatingRepo ratingRepo;

    public QuotesRatingService(RatingRepo quotesRepo) {
        this.ratingRepo = quotesRepo;

        this.ratingRepo.save(new Rating(1L,3));
        this.ratingRepo.save(new Rating(2L,4));
        this.ratingRepo.save(new Rating(3L,2));
        this.ratingRepo.save(new Rating(4L,5));

    }


    public Integer rateQuote(Long id) {
        Rating rating = ratingRepo.getOne(id);
        return rating.getRating();
    }

}
