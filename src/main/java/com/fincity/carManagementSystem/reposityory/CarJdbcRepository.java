package com.fincity.carManagementSystem.reposityory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fincity.carManagementSystem.dao.CarsDAO;
import com.fincity.carManagementSystem.model.Car;

@Repository
public class CarJdbcRepository implements CarsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	class CarRowMapper implements RowMapper<Car> {
		@Override
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			Car car = new Car();
			car.setCarId(rs.getInt("carId"));
			car.setName(rs.getString("name"));
			car.setManufacturerName(rs.getString("manufacturerName"));
			car.setModel(rs.getString("model"));
			car.setManufacturingYear(rs.getString("manufacturingYear"));
			car.setColor(rs.getString("color"));
			
			return car;
		}
	}
	
	@Override
	public boolean insertCar(Car car) {
		try {
			String query = "insert into cars(name, manufacturerName, model, manufacturingYear, color) values( ?, ?, ?, ?, ?)";
			jdbcTemplate.update(query,
					new Object[] { car.getName(), car.getManufacturerName(), car.getModel(), car.getManufacturingYear(), car.getColor() });
			return true;
		} catch(Error e) {
			return false;
		}

	}

	@Override
	public boolean updateCar(Car car) {
		try {
			String query = "update cars set name = ?, manufacturerName = ?, model = ?, manufacturingYear = ?, color = ? where carid = ?";
			jdbcTemplate.update(query,
					new Object[] { car.getName(), car.getManufacturerName(), car.getModel(), car.getManufacturingYear(), car.getColor() });
			return true;
		} catch(Error e) {
			return false;
		}

	}

	@Override
	public boolean deleteCar(int id) {
		try {
			jdbcTemplate.update("delete from cars where carid=?", new Object[] { id });
			return true;
		} catch(Error e) {
			return false;
		}
	}

	@Override
	public List<Car> findAll() {
		return jdbcTemplate.query("select * from cars", new CarRowMapper());
	}

	@Override
	public Car findById(int id) {
		try {
			return jdbcTemplate.queryForObject("select * from cars where carid=?", new Object[] { id },
					new BeanPropertyRowMapper<Car>(Car.class));
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Car> findByName(String name) {
		return jdbcTemplate.query("select * from cars where name like ?", new Object[] { name },new CarRowMapper());
	}

	@Override
	public List<Car> findByManufacturerName(String manufacturerName) {
		return jdbcTemplate.query("select * from cars where manufacturerName like ?", new Object[] { manufacturerName },new CarRowMapper());
	}

	@Override
	public List<Car> findByModel(String model) {
		return jdbcTemplate.query("select * from cars where model like ?", new Object[] { model },new CarRowMapper());
	}

	@Override
	public List<Car> findByManufacturingYear(String manufacturingYear) {
		return jdbcTemplate.query("select * from cars where manufacturingYear like ?", new Object[] { manufacturingYear },new CarRowMapper());
	}

	@Override
	public List<Car> findByColor(String color) {
		return jdbcTemplate.query("select * from cars where color like ?", new Object[] { color },new CarRowMapper());
	}

}
