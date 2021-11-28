package com.cf.weather.bo;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class WheatherMapBO {
	private WheatherMapCoord coord;
	private WheatherMapWeatherInfo[] weather;
	private String base;
	private WheatherMapTemp main;
	private long visibility;
	private WheatherMapWind wind;
	private WheatherMapClouds clouds;
	private long dt;
	private WheatherMapSys sys;
	private long timezone;
	private long id;
	private String name;
	private long cod;
}






