package com.example.demo.mapper;

import com.example.demo.connector.dto.CityDTO;
import com.example.demo.connector.dto.OpenWeatherDTO;
import com.example.demo.connector.dto.TemperatureInfoDTO;
import com.example.demo.connector.dto.WeatherInfoDTO;
import com.example.demo.domain.City;
import com.example.demo.domain.OpenWeather;
import com.example.demo.domain.TemperatureInfo;
import com.example.demo.domain.WeatherInfo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@Mapper
public interface OpenWeatherInboundMapper {

    int OPEN_WEATHER_DATE_MULTIPLIER = 1000;

    OpenWeather mapToOpenWeather(OpenWeatherDTO openWeatherDTO);

    City mapToCity(CityDTO cityDTO);

    List<WeatherInfo> mapToWeatherInfoList(List<com.example.demo.connector.dto.WeatherInfoDTO> weatherInfoDTOs);

    default WeatherInfo mapToWeatherInfo(WeatherInfoDTO weatherInfoDTO) {
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setForecastDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(weatherInfoDTO.getDt() * OPEN_WEATHER_DATE_MULTIPLIER),
                ZoneId.systemDefault()));
        weatherInfo.setTemperatureInfo(mapToTemperatureInfo(weatherInfoDTO.getMain()));
        return weatherInfo;
    }

    TemperatureInfo mapToTemperatureInfo(TemperatureInfoDTO temperatureInfoDTO);

}
