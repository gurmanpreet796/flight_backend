package com.org.model;

import lombok.Data;
import lombok.Generated;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Users {
	private String userType;
	@Id
	@GeneratedValue()
	private Long userId;
	private String userName;
	private String userPassword;
	private Long userPhone;
	private String userEmail;



}