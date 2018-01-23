package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

    private String city;
    private String countryCode;
    private List<TemperaturesDTO> temperatures;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<TemperaturesDTO> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<TemperaturesDTO> temperatures) {
        this.temperatures = temperatures;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
