package com.org.model;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data
public class Booking {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private Long bookingId;
	private String bookingDate;
	private int noOfPassengers;
}