package com.walmart.Sensor.model;

public class Sensor {

	private int sensorId;

	private String timestamp;
	private int value;

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

	@Override
	public String toString() {
		return "Sensor [sensorId=" + sensorId + ", timestamp=" + timestamp + ", value=" + value + "]";
	}
}
