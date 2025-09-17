package com.walmart.Sensor.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.walmart.Sensor.Config.ApplicationConfig;
import com.walmart.Sensor.model.EnrichedData;
import com.walmart.Sensor.model.LatchStringPair;
import com.walmart.Sensor.model.Location;
import com.walmart.Sensor.model.Sensor;

@Service
public class ProducerService {

	@Autowired
	private ApplicationConfig config;

	Logger log = LoggerFactory.getLogger(ConsumerService.class);

	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendSensor(Sensor sensor) throws InterruptedException {

		try {

			CountDownLatch countDownLatch = new CountDownLatch(2);
			config.sensorTrack.put(sensor.getSensorId(), new LatchStringPair(countDownLatch, new EnrichedData()));

			template.send("Sensor-topic", sensor);

			// Wait for Listener to consumes the message from both Sensor topic and Location
			// Topic or Maximum time of 25 secs.
			countDownLatch.await(25, TimeUnit.SECONDS);

			enrichData(sensor.getSensorId());
		} catch (Exception e) {
            log.error("Error porcessing  on this sensor ID {}",  sensor.getSensorId() );
		}

	}

	public void sendLocation(Location location) {

		template.send("Location-topic", location);
	}

	public void enrichData(int id) {

		LatchStringPair latchStringPair = config.getSensorTrack().get(id);
		System.out.println(latchStringPair.getEnrichedData().toString());
		if (ObjectUtils.isEmpty(latchStringPair.getEnrichedData())) {
			config.getSensorTrack().remove(id);
			log.info("No data to publish");
		} else {
			EnrichedData data = latchStringPair.getEnrichedData();
			template.send("Output-topic", data);
			config.getSensorTrack().remove(id);
		}

	}

}
