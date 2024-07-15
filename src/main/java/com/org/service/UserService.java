package com.org.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.org.model.Users;

public interface UserService {

	public Users createUser(Users newUser);

	public Users updateUser(Users newUser);

	public String deleteUser(Long UserId);

	public Iterable<Users> displayAllUser();

	public Users findUserById(Long userId);
	public String getRoleByUsername(String userName);
}