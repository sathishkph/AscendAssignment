package com.walmart.Sensor.model;

public class Location {
	private int sensorId;
	private String location;
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Location [sensorId=" + sensorId + ", location=" + location + "]";
	}

}
