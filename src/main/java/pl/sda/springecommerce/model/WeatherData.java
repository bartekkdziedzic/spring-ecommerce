package pl.sda.springecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherData {
    private Current current;

    // Getter and setter for the "current" field


    public static class Current {
        private Double temp_c;

        public Double getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(Double temp_c) {
            this.temp_c = temp_c;
        }
// Getter and setter for the "temp_c" field
    }
}
