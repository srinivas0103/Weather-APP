package com.cf.weather.services;

import java.text.DecimalFormat;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cf.weather.bo.RestWeatherResponseBO;
import com.cf.weather.bo.WeatherStackBO;
import com.cf.weather.bo.WheatherMapBO;

@Service
public class WeatherService {  
    private final RestTemplate restTemplate;
   
    @Value("${KELVIN_CONV:273.15}")
    private double KELVIN_CONV;

    @Value("${CF.CONN_TIMEOUT:5}")
    private long TIMEOUT;
    
    @Value("${CF.CNTRY:AU}")
    private String CNTRY;
    
    @Value("${CF.WHETHER_STACK_URL}")
    private String WHETHER_STACK_URL;
    
    @Value("${CF.WHETHER_MAP_URL}")
    private String WHETHER_MAP_URL;
    
    @Value("${CF.WHETHER_MAP_CNTRY}")
    private String WHETHER_MAP_CNTRY;
    
    @Value("${CF.WHETHER_MAP_URL_KEY}")
    private String WHETHER_MAP_URL_KEY;
    
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    
    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(TIMEOUT)).build();
    }
   
   @Cacheable(value="three-second-cache", key="#city")
    public ResponseEntity<RestWeatherResponseBO> weatherForecastByCity(String city) {
    RestWeatherResponseBO  response = new RestWeatherResponseBO();
       
    try {         	
           	String urlWeatherStack = this.getWhetherStackURL(city);   
           	WeatherStackBO weatherStackBO = this.restTemplate.getForObject(urlWeatherStack, WeatherStackBO.class);
        	response.setWind_speed(weatherStackBO.getCurrent().getWind_speed() + "");
        	response.setTemperature_degrees(weatherStackBO.getCurrent().getTemperature() + ""); 
        }catch (RestClientException e) {
        	System.out.println("RestClientException" + e.getMessage());        	
        	String urlWeatherMapFallBack = this.getWhetherMapURL(city);    
        	WheatherMapBO wheatherMapBO = this.restTemplate.getForObject(urlWeatherMapFallBack, WheatherMapBO.class);        	       	
        	response.setWind_speed(mpsToKmph(wheatherMapBO.getWind().getSpeed()));      
        	response.setTemperature_degrees(kelvinToDegrees(wheatherMapBO.getMain().getTemp()));
        }catch (Exception e) {
        	System.out.println("Exception" + e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
        
    private String mpsToKmph(double mps)
    {
    	double kmph = (3.6 * mps);
    	return df.format(kmph);
    }
    
    private String kelvinToDegrees (double kelvinTemp)
    {
    	double degrees = kelvinTemp - KELVIN_CONV;
    	return df.format(degrees);
    }
    

	private String getWhetherStackURL(String city) {
		String url = WHETHER_STACK_URL +city;
		return url;
	}

	private String getWhetherMapURL(String city) {
		String url = WHETHER_MAP_URL + city + WHETHER_MAP_CNTRY + WHETHER_MAP_URL_KEY;
		return url;
	}	
}
