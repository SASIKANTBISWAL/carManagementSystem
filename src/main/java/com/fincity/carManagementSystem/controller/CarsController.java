package com.fincity.carManagementSystem.controller;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fincity.carManagementSystem.model.Car;
import com.fincity.carManagementSystem.reposityory.CarJdbcRepository;

@RestController
public class CarsController {
	
	@Autowired
	private CarJdbcRepository carJdbcRepository;
	
	@RequestMapping(value="/cars", method=RequestMethod.GET)
	public @ResponseBody Object getAllCars() {
		try {
			return new ResponseEntity<List<Car>>(carJdbcRepository.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/cars/{id}", method=RequestMethod.GET)
	public @ResponseBody Object getCarWithId(@PathVariable @NotNull @DecimalMin("0") int id) {
		try {
			Car car = carJdbcRepository.findById(id);
			if(car != null) {
				return new ResponseEntity<Car>(car, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/cars/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Object deleteCarWithId(@PathVariable @NotNull @DecimalMin("0") int id) {
		try {
			if(carJdbcRepository.deleteCar(id)) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/cars/{search}/{tag}", method=RequestMethod.GET)
	public @ResponseBody Object getCarWithId(@PathVariable @NotNull String search ,@PathVariable @NotNull String tag) {
		try {
			if(search.equalsIgnoreCase("name")) {
				return new ResponseEntity<List<Car>>(carJdbcRepository.findByName(tag), HttpStatus.OK);
			} else if(search.equalsIgnoreCase("manufacturerName")) {
				return new ResponseEntity<List<Car>>(carJdbcRepository.findByManufacturerName(tag), HttpStatus.OK);
			} else if(search.equalsIgnoreCase("model")) {
				return new ResponseEntity<List<Car>>(carJdbcRepository.findByModel(tag), HttpStatus.OK);
			} else if(search.equalsIgnoreCase("manufacturingYear")) {
				return new ResponseEntity<List<Car>>(carJdbcRepository.findByManufacturingYear(tag), HttpStatus.OK);
			} else if(search.equalsIgnoreCase("color")) {
				return new ResponseEntity<List<Car>>(carJdbcRepository.findByColor(tag), HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object> (null, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/cars", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object postCar(@RequestBody Car car) {
		try {
			if(carJdbcRepository.insertCar(car)) {
				return new ResponseEntity<Object> (HttpStatus.OK);
			} else {
				return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	} 
	
	@RequestMapping(value="/cars/{id}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object putCar(@RequestBody Car car) {
		try {
			if(carJdbcRepository.updateCar(car)) {
				return new ResponseEntity<Object> (HttpStatus.OK);
			} else {
				return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
}
