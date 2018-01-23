package com.example.demo.connector.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDTO {

    private CityDTO city;
    private List<WeatherInfoDTO> list;

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public List<WeatherInfoDTO> getList() {
        return list;
    }

    public void setList(List<WeatherInfoDTO> list) {
        this.list = list;
    }
}
