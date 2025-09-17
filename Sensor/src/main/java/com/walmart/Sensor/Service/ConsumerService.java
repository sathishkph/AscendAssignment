package com.walmart.Sensor.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.walmart.Sensor.Config.ApplicationConfig;
import com.walmart.Sensor.model.EnrichedData;
import com.walmart.Sensor.model.LatchStringPair;
import com.walmart.Sensor.model.Location;
import com.walmart.Sensor.model.Sensor;

@Service
public class ConsumerService {
	
	 @Autowired
	    private ApplicationConfig config;

	Logger log = LoggerFactory.getLogger(ConsumerService.class);
	
	@Autowired 
	private ProducerService producerService;

	@KafkaListener(topics = "Sensor-topic", groupId = "sensor_group")
	public void consumerMessage(Sensor sensor) {
		log.info("Sensor Message is being consumed : {}", sensor);
		
		if (config.sensorTrack.containsKey(sensor.getSensorId())){
			
			LatchStringPair latchStringPair = config.getSensorTrack().get(sensor.getSensorId());
			//latchStringPair.setEnrichedData()
			EnrichedData enrichedData = new EnrichedData();
			enrichedData.setSensorId(sensor.getSensorId());
			
			enrichedData.setTimestamp(sensor.getTimestamp());
			enrichedData.setValue(sensor.getValue());
			
			latchStringPair.setEnrichedData(enrichedData);
			System.out.println(latchStringPair.getEnrichedData());
			latchStringPair.getCountDownLatch().countDown();
			System.out.println(latchStringPair.getEnrichedData());
			 
		}
		
	}

	@KafkaListener(topics = "Location-topic",groupId = "first_group")
	public void consumJsonMessage(Location loc) {
		log.info("Location Message is being consumed : {}",loc);
		
if (config.sensorTrack.containsKey(loc.getSensorId())){
			
			LatchStringPair latchStringPair = config.getSensorTrack().get(loc.getSensorId());
			latchStringPair.getEnrichedData().setLocation(loc.getLocation());
			latchStringPair.getCountDownLatch().countDown();	
					 
		}


}
}
//sensor topic publish --> 