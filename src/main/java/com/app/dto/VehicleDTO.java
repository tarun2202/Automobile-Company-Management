package com.app.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Company;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank
	private String vehicleName;

	private Company company;
	@NotBlank
	@Length(max = 10)
	private String vehicleNumber;
	@NotBlank
	private String vehicleType;

	@JsonProperty(access = Access.READ_ONLY)
	private Long userId;

}
