package com.walmart.Sensor.model;

import java.util.concurrent.CountDownLatch;

public class LatchStringPair {
	
	private CountDownLatch countDownLatch;
	
	public LatchStringPair() {
		super();
		// TODO Auto-generated constructor stub
	}
	private EnrichedData enrichedData;
	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}
	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	public EnrichedData getEnrichedData() {
		return enrichedData;
	}
	public void setEnrichedData(EnrichedData enrichedData) {
		this.enrichedData = enrichedData;
	}
	public LatchStringPair(CountDownLatch countDownLatch, EnrichedData enrichedData) {
		super();
		this.countDownLatch = countDownLatch;
		this.enrichedData = enrichedData;
	}
	

}
