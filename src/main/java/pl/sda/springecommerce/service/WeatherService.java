package pl.sda.springecommerce.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.sda.springecommerce.model.WeatherData;

@Service
public class WeatherService {
    private final WebClient webClient;

    @Value("${weatherapi.api.url}")
    private String weatherApiUrl;

    @Value("${weatherapi.api.key}")
    private String apiKey;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(weatherApiUrl).build();
    }

    public WeatherData getWeatherForCity(String cityName) {
        return webClient
                .get()
                .uri("/current.json?q={city}&key={apiKey}", cityName,apiKey)
                .retrieve()
                .bodyToMono(WeatherData.class)
                .block();
    }
}
