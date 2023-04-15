package cs.ubbluj.mapper;


import org.json.JSONException;
import org.json.JSONObject;
import cs.ubbluj.model.Weather;


public class WeatherMapper {

    public static Weather mapWeatherFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject data = jsonObject.getJSONArray("data").getJSONObject(0);
        Weather weather = new Weather(data.getString("city_name"),
                data.getInt("app_temp"),
                data.getString("country_code"),
                data.getString("datetime"),
                data.getInt("clouds"));
        return weather;
    }
}
