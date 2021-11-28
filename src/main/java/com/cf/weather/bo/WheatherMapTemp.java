package com.cf.weather.bo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WheatherMapTemp {
		public double temp;
		public double feelsLike;
		public double tempMin;
		public double tempMax;
		public long pressure;
		public long humidity;
}
