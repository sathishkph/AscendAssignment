package com.walmart.Sensor.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.walmart.Sensor.model.LatchStringPair;

@Configuration
public class ApplicationConfig {
	public Map<Integer , LatchStringPair> sensorTrack = new HashMap<>();

	public Map<Integer, LatchStringPair> getSensorTrack() {
		return sensorTrack;
	}

	public void setSensorTrack(Map<Integer, LatchStringPair> sensorTrack) {
		this.sensorTrack = sensorTrack;
	}

}
