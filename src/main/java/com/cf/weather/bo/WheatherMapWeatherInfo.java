package com.cf.weather.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WheatherMapWeatherInfo {
	public long id;
	public String main;
	public String description;
	public String icon;
}