package com.example.demo.connector.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfoDTO {

    private long dt;
    private TemperatureInfoDTO main;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public TemperatureInfoDTO getMain() {
        return main;
    }

    public void setMain(TemperatureInfoDTO temperatureInfoDTO) {
        this.main = temperatureInfoDTO;
    }
}
