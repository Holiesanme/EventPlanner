package cs.ubbluj.controller;


import cs.ubbluj.model.Weather;
import cs.ubbluj.service.WeatherService;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public ResponseEntity<Weather> getCurrentWeather() throws JSONException {

        Weather weather = weatherService.getCurrentWeather();
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }
}
