package com.walmart.Sensor.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.Sensor.Service.ProducerService;
import com.walmart.Sensor.model.Location;
import com.walmart.Sensor.model.Sensor;

@SpringBootApplication
@RestController
//@RequestMapping("/producer")
public class ProducerController {
	
	  
	
	@Autowired
	private ProducerService prodcuerService;
	
	@PostMapping("/sensor")
	public ResponseEntity<?> produceSensor(@RequestBody Sensor sensor) throws InterruptedException{
		System.out.println("sensor             " + sensor);
		prodcuerService.sendSensor(sensor);
		
		return ResponseEntity.ok("Message is published successfully");
		
		
	}
	
	
	@GetMapping("/location/{sensorId}/{location}")
	public ResponseEntity<?> produceLocation(@PathVariable int sensorId ,@PathVariable String location ){
		Location loc = new Location();
		loc.setLocation(location);
		loc.setSensorId(sensorId);
		
		prodcuerService.sendLocation(loc);
		return ResponseEntity.ok("Message is published successfully");
		
		
	}

}
