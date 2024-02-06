package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
@ToString(exclude = "password", callSuper = true)
public class User extends BaseEntity {
	@Column(length = 50)
	@NotBlank
	private String userName;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	@Length(min = 6)
	@Column(length = 100)
	private String password;
	@Column(length = 50)
	@NotBlank
	private String city;
	@Column(length = 15)
	@NotBlank
	@Length(max = 10)
	private String phoneNo;

	// one,parent,inverse
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	
	// helper method to add vehicle
	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
		v.setUser(this);
	}

	// helper method to remove vehicle
	public void removeVehicle(Vehicle v) {
		this.vehicles.remove(v);
		v.setUser(null);
	}

	public User(String userName, String email, String password, String city, String phoneNo) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.phoneNo = phoneNo;
	}

}
