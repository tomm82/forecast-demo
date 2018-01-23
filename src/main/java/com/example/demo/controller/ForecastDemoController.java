package com.example.demo.controller;

import com.example.demo.domain.OpenWeather;
import com.example.demo.dto.WeatherDTO;
import com.example.demo.mapper.OutboundMapper;
import com.example.demo.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@RestController
@RequestMapping(value = "/forecast")
public class ForecastDemoController {

    @Autowired
    private OpenWeatherService openWeatherService;

    @Autowired
    private OutboundMapper outboundMapper;

    @RequestMapping("/five-days/{city}")
    public WeatherDTO showForecast(@PathVariable String city) {
        OpenWeather openWeather = openWeatherService.getForecastByCityName(city);
        return outboundMapper.mapToWeatherDto(openWeather);
    }
}
