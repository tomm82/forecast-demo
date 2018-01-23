package com.example.demo.service;

import com.example.demo.connector.OpenWeatherConnector;
import com.example.demo.domain.OpenWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@Service
public class OpenWeatherService {

    @Autowired
    private OpenWeatherConnector openWeatherConnector;

    public OpenWeather getForecastByCityName(String city) {
        return openWeatherConnector.getForecastByCityName(city);
    }
}
