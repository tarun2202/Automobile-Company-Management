package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true,exclude = {"user"})
public class Vehicle extends BaseEntity {

	@Column(length = 20)
	@NotBlank
	private String vehicleName;
	@Enumerated(EnumType.STRING)
	private Company company;
	@NotBlank
	@Column(length = 15)
	private String vehicleNumber;
	@NotBlank
	@Column(length = 30)
	private String vehicleType;

	// many,child,owning side(FK)
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
