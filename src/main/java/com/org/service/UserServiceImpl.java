package com.org.service;

import java.math.BigInteger;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.dao.UserDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public Users createUser(Users newUser) {
		// TODO Auto-generated method stub
		//Optional<Users> findUserById = userDao.findById(newUser.getUserId());
		//try {
		//	if (findUserById.isEmpty()) {
			 return  userDao.save(newUser);
				//return new ResponseEntity<Users>(newUser, HttpStatus.OK);
//			} else
//				throw new RecordAlreadyPresentException(
//						"User with Id: " + newUser.getUserId() + " already exists!!");
		}
		/*catch (RecordAlreadyPresentException e) {
                e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
	//}

	@Override
	public Users updateUser(Users updateUser) {
		// TODO Auto-generated method stub
		Optional<Users> findUserById = userDao.findById(updateUser.getUserId());
		if (findUserById.isPresent()) {
			userDao.save(updateUser);
		} else
			throw new RecordNotFoundException(
					"User with Id: " + updateUser.getUserId() + " not exists!!");
		return updateUser;
	}

	@Override
	public String deleteUser(Long UserId) {
		// TODO Auto-generated method stub
		Optional<Users> findBookingById = userDao.findById(UserId);
		if (findBookingById.isPresent()) {
			userDao.deleteById(UserId);
			return "User Deleted!!";
		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	@Override
	public Iterable<Users> displayAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	@Override
	public Users findUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<Users> findById = userDao.findById(userId);
		//try {
			if (findById.isPresent()) {
				Users findUser = findById.get();
				return  findUser;
			//	return new ResponseEntity<Users>(findUser, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + userId);
		}
	@Override
	public String getRoleByUsername(String username) {
		Optional<Users> user = userDao.findByUserName(username);
		if (user.isPresent()) {
			return user.get().getUserType();
		} else {
			throw new RecordNotFoundException("User not found with username: " + username);
		}
	}

//		catch (RecordNotFoundException e) {
//			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	//}

}