package com.cf.weather.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherStackLocation {
	public String name;
	public String country;
	public String region;
	public String lat;
	public String lon;
	public String timezone_id;
	public String localtime;
	public int localtime_epoch;
	public String utc_offset;	
}