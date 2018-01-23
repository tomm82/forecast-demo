package com.example.demo.connector.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDTO {

    private String name;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
