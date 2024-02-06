package com.app.service;

import java.util.List;

import com.app.dto.ApiResponseDTO;
import com.app.dto.VehicleDTO;

public interface VehicleService {

	public ApiResponseDTO addVehicleDetails(Long userId, VehicleDTO vehicleDTO);

	public List<VehicleDTO> getAllVehicleDetails(String userName);

	public ApiResponseDTO deleteVehicleDetails(String userName, Long vehicleId);

}
