package com.fincity.carManagementSystem.model;


public class Car {
	private Integer carId;
	private String name;
	private String manufacturerName;
	private String model;
	private String manufacturingYear;
	private String color;
	
	public Car() {
		super();
	}

	public Car(String name, String manufacturerName, String model, String manufacturingYear, String color) {
		super();
		this.name = name;
		this.manufacturerName = manufacturerName;
		this.model = model;
		this.manufacturingYear = manufacturingYear;
		this.color = color;
	}

	public Car(Integer carId, String name, String manufacturerName, String model, String manufacturingYear,
			String color) {
		super();
		this.carId = carId;
		this.name = name;
		this.manufacturerName = manufacturerName;
		this.model = model;
		this.manufacturingYear = manufacturingYear;
		this.color = color;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", name=" + name + ", manufacturerName=" + manufacturerName + ", model=" + model
				+ ", manufacturingYear=" + manufacturingYear + ", color=" + color + "]";
	}
}
