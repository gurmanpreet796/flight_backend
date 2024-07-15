package com.org.model;

import lombok.Data;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Passenger {

	@Id
	private Long pnrNumber;
	private String passengerName;
	private int passengerAge;
	private Long passengerUIN;
	private Double luggage;


}
