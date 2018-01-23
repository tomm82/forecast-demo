package com.example.demo.mapper;

import com.example.demo.domain.OpenWeather;
import com.example.demo.domain.WeatherInfo;
import com.example.demo.dto.TemperaturesDTO;
import com.example.demo.dto.WeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@Mapper
public interface OutboundMapper {

    @Mappings({
            @Mapping(source = "city.name", target = "city"),
            @Mapping(source = "city.country", target = "countryCode"),
            @Mapping(source = "list", target = "temperatures")
    })
    WeatherDTO mapToWeatherDto(OpenWeather openWeather);

    List<TemperaturesDTO> mapToTemperaturesDtos(List<WeatherInfo> value);

    @Mappings({
            @Mapping(source = "temperatureInfo.temp", target = "temp"),
            @Mapping(source = "temperatureInfo.pressure", target = "pressure"),
            @Mapping(source = "temperatureInfo.humidity", target = "humidity"),
    })
    TemperaturesDTO maToTemperaturesDto(WeatherInfo weatherInfo);

}
