package com.cf.weather.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WheatherMapSys {
	public long type;
	public long id;
	public String country;
	public long sunrise;
	public long sunset;
}