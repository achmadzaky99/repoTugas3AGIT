package id.co.astratech.tugas3agit_achmad_zaky_fauzan.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class WeatherService {
    private static final String url = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";

    private static final String apiKey = "f61318aec7360423e031b417723de82e";

    @Autowired
    private RestTemplate restTemplate;

    public Object getCurrentWeather(String city) {
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, city, apiKey);
            log.info("Output API: {}", response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException e) {
            log.error("HTTP error occurred while calling OpenWeatherMap API: {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.valueOf(e.getRawStatusCode()),
                    "HTTP error occurred while calling OpenWeatherMap API: " + e.getResponseBodyAsString(),
                    e
            );
        } catch (Exception e) {
            log.error("Error occurred while calling OpenWeatherMap API", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception occurred while calling OpenWeatherMap API",
                    e
            );
        }

        }
    }
