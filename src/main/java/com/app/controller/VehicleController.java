package com.app.controller;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VehicleDTO;
import com.app.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	// REST API end point for adding new vehicle
	// URL : http://localhost:8080/users/{userId}
	// Method :POST
	// resp :sc201,vehicle added msg
	@PostMapping("/{userId}")
	public ResponseEntity<?> addVehicle(@PathVariable Long userId, @RequestBody VehicleDTO vehicleDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicleDetails(userId, vehicleDTO));
	}

	// REST API end point for fetching all vehicles for user by username
	// URL : http://localhost:8080/users/
	// Method :GET
	// resp :sc200,List<Vehicle>
	@GetMapping("/{userName}")
	public ResponseEntity<?> getAllVehicles(@PathVariable String userName) {
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicleDetails(userName));
	}

	// REST API end point for deleting a vehicle for user by username
	// URL : http://localhost:8080/users/
	// Method :DELETE
	// resp :sc200,Succesfull deletion msg
	@DeleteMapping("/{userName}/{vehicleId}")
	public ResponseEntity<?> deleteVehicle(@PathVariable String userName,@PathVariable Long vehicleId ){
		return ResponseEntity.status(HttpStatus.OK).body(vehicleService.deleteVehicleDetails(userName,vehicleId));
	}
	

}
