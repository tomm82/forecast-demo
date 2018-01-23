package com.example.demo.connector;

import com.example.demo.connector.dto.OpenWeatherDTO;
import com.example.demo.domain.OpenWeather;
import com.example.demo.mapper.OpenWeatherInboundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @author <a href="mailto:tomasz.andrzejewski@teliasonera.com">Tomasz Andrzejewski</a>
 */
@Component
public class OpenWeatherConnector {

    private static final Logger openWeatherLogger = Logger.getLogger("OpenWeatherConnectorLogger");
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${openweather.url}")
    private String openWeatherUrl;

    @Autowired
    private OpenWeatherInboundMapper translator;

    @Cacheable("forecasts")
    public OpenWeather getForecastByCityName(String city) {
        OpenWeatherDTO openWeatherDTO = restTemplate.getForObject(openWeatherUrl, OpenWeatherDTO.class, city);
        return translator.mapToOpenWeather(openWeatherDTO);
    }

    @CacheEvict(allEntries = true, cacheNames = { "forecasts" })
    @Scheduled(fixedDelay = 30000)
    public void cacheEvict() {
        openWeatherLogger.info("Forecast cache evicted");
    }
}
