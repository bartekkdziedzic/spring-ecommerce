package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springecommerce.model.WeatherData;
import pl.sda.springecommerce.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/Warsaw")
    public ResponseEntity<WeatherData> getWeatherForWarsaw() {
        WeatherData weatherData = weatherService.getWeatherForCity("Warsaw");
        return ResponseEntity.ok(weatherData);
    }
}