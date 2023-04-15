package cs.ubbluj.model;

public class Weather {
    private String cityName;
    private int temperature;
    private String countryCode;
    private String dateTime;
    private int clouds;

    public Weather(String cityName, int temperature, String countryCode, String dateTime, int clouds) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.countryCode = countryCode;
        this.dateTime = dateTime;
        this.clouds = clouds;

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", countryCode='" + countryCode + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", clouds=" + clouds +
                '}';
    }
}
















