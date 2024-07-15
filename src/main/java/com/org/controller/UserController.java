package com.org.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.Users;
import com.org.service.UserService;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular app
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	//@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Users> addUser(@RequestBody Users newUser) {
		try {
			System.out.println(newUser+".................................");
			return new ResponseEntity<Users>(userService.createUser(newUser), HttpStatus.CREATED);
		}
		catch (RecordNotFoundException e){

			return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/readAllUsers")
	public Iterable<Users> readAllUsers() {
		return userService.displayAllUser();
	}

	@PutMapping("/updateUser")
	//@ExceptionHandler(RecordNotFoundException.class)
	public void updateUser(@RequestBody Users updateUser) {
		userService.updateUser(updateUser);
	}

	@GetMapping("/searchUser/{id}")
	//@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Users> searchUserByID(@PathVariable("id") Long userId) {
		try {
			return new ResponseEntity<Users>(userService.findUserById(userId), HttpStatus.FOUND);
		}
		catch (RecordNotFoundException e){
			return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getRole")
	public ResponseEntity<String> getRole(@RequestParam String username)
	{
		try {
			String role = userService.getRoleByUsername(username);
			//return ResponseEntity.ok(role);
			//Ok(new { message = "string" })
			//" \" valid \" "
			//return ResponseEntity.ok(" \" +role+ \" ");
			return ResponseEntity.ok(role);
		} catch (RecordNotFoundException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	//@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
	}
}
