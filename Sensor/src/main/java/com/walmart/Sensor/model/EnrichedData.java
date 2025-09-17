package com.walmart.Sensor.model;

public class EnrichedData {
	
	private int sensorId;
	//private Timestamp timestamp;
	private String timestamp;
	private int value;
	private String location;
	
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "EnrichedData [sensorId=" + sensorId + ", timestamp=" + timestamp + ", value=" + value + ", location="
				+ location + "]";
	}
	
	

}

