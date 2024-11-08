package utn.frba.disenio.tp.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import utn.frba.disenio.tp.mocks.MockAccuWeather;
import utn.frba.disenio.tp.services.external.AccuWeatherAPI;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public AccuWeatherAPI getAccuWeatherAPI() {
        return new MockAccuWeather();
    }
}