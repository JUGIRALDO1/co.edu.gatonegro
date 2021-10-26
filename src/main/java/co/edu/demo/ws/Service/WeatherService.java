package co.edu.demo.ws.Service;

import co.edu.demo.ws.rest.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "849bf97ee34f7e61248ab185104b7e6b";
    private static final String UNIT = "metric";    

    public Weather getWeatherBy(String zip, String country) {
        RestTemplate restTemplate = new RestTemplate();
        String urlRestWS = String.format("%s?zip=%s,%s&units=%s&APPID=%s", 
                WEATHER_URL,
                zip,
                country,
                UNIT,
                API_KEY);
        Weather weatherRoot = restTemplate.getForObject(urlRestWS, Weather.class);        
        log.info(weatherRoot.toString());
        return weatherRoot;
    }
}

