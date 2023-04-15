package cs.ubbluj.service;


import cs.ubbluj.mapper.WeatherMapper;
import cs.ubbluj.model.Weather;
import org.json.JSONException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {


    public String getResponseBodyExternalAPI(){

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "6becb90893msh0dc2fd6ea643d0bp116f3bjsn17d93991a0b7");
        headers.set("X-RapidAPI-Host", "weatherbit-v1-mashape.p.rapidapi.com");
        String url = "https://weatherbit-v1-mashape.p.rapidapi.com/current?lon=23.6236&lat=46.7712";

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, String.class);
        String responseBody = response.getBody();
        return responseBody;

    }
    public String getResponseBodyDummy()
    {
        return "{\"count\":1,\"data\":[{\"app_temp\":1,\"aqi\":98,\"city_name\":\"Cluj-Napoca\",\"clouds\":81,\"country_code\":\"RO\",\"datetime\":\"2023-01-07:08\",\"dewpt\":2,\"dhi\":62.87,\"dni\":569.53,\"elev_angle\":12.83,\"ghi\":181.28,\"gust\":null,\"h_angle\":-45,\"lat\":46.7712,\"lon\":23.6236,\"ob_time\":\"2023-01-07 08:30\",\"pod\":\"d\",\"precip\":0,\"pres\":973,\"rh\":93,\"slp\":1024,\"snow\":0,\"solar_rad\":101.6,\"sources\":[\"LRCL\"],\"state_code\":\"13\",\"station\":\"LRCL\",\"sunrise\":\"06:08\",\"sunset\":\"14:53\",\"temp\":3,\"timezone\":\"Europe/Bucharest\",\"ts\":1673080200,\"uv\":0.6181205,\"vis\":16,\"weather\":{\"description\":\"Broken clouds\",\"code\":803,\"icon\":\"c03d\"},\"wind_cdir\":\"ENE\",\"wind_cdir_full\":\"east-northeast\",\"wind_dir\":60,\"wind_spd\":2.1}]}";
    }
    public Weather getCurrentWeather() throws JSONException {

        return WeatherMapper.mapWeatherFromJson(getResponseBodyExternalAPI());


    }
}
