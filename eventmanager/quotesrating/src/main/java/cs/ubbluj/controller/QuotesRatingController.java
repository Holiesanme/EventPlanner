package cs.ubbluj.controller;


import cs.ubbluj.service.QuotesRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cs.ubbluj.model.Rating;

@RestController
@RequestMapping("/rating")
public class QuotesRatingController {
    private final QuotesRatingService quotesRatingService;

    public QuotesRatingController(QuotesRatingService quotesRatingService) {
        this.quotesRatingService = quotesRatingService;
    }

    @GetMapping("/rate")
    public ResponseEntity<Rating> getRandomInspirationalQuote(@RequestParam Long id) {
        Rating rating = new Rating(null, quotesRatingService.rateQuote(id));
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }
}
