package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_global_exception.GlobalExceptionHandler;
import com.app.dao.UserDao;
import com.app.dao.VehicleDao;
import com.app.dto.ApiResponseDTO;
import com.app.dto.VehicleDTO;
import com.app.entities.User;
import com.app.entities.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private VehicleDao vehicleDao;

	@Override
	public ApiResponseDTO addVehicleDetails(Long userId, VehicleDTO vehicleDTO) {

		User user = userDao.findById(userId)
				.orElseThrow(() -> new GlobalExceptionHandler().ResourceNotFoundException("Invalid user id!"));

		Vehicle vehicleEntity = mapper.map(vehicleDTO, Vehicle.class);

		user.addVehicle(vehicleEntity);

		return new ApiResponseDTO("Vehicle added succesfull!");
	}

	@Override
	public List<VehicleDTO> getAllVehicleDetails(String userName) {

		User user = userDao.getByUserName(userName);

		List<Vehicle> list = user.getVehicles();

		List<VehicleDTO> listDTO = list.stream().map(vehicle -> mapper.map(vehicle, VehicleDTO.class))
				.collect(Collectors.toList());

		return listDTO;
	}

	@Override
	public ApiResponseDTO deleteVehicleDetails(String userName, Long vehicleId) {
		User user = userDao.getByUserName(userName);

		Vehicle vehicle = vehicleDao.getReferenceById(vehicleId);//.orElseThrow(
				//() -> new GlobalExceptionHandler().ResourceNotFoundException("Invalid user id or vehicle id!"));
		user.removeVehicle(vehicle);

		return new ApiResponseDTO("Deletion succesfull!");
	}

}
