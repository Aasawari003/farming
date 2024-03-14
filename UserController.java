package com.farming.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farming.models.User;
import com.farming.repository.UserRepository;
import com.farming.service.UserService;
//import com.farming.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	    public UserController(UserService userService) {
        this.userService = userService;
    }
	    
	    @GetMapping("/register")
	    public String getRegisterPage() {
	        // Logic to return the registration page HTML
	       return "redirect:/register.html"; // Assuming "register" is the name of your HTML file
	    }   
	    
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		 if (userService.isUserWithEmailExists(user.getEmail())) {
	            return new ResponseEntity<>("User with this email already exists", HttpStatus.BAD_REQUEST);
	        }
		 userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
//	public User createUser(@RequestBody User user)
//	{
//		User newUser=new User();
//		newUser.setEmail(user.getEmail());
//		newUser.setName(user.getName());
//		newUser.setPassword(user.getPassword());
//		newUser.setContactinfo(user.getContactinfo());
//		newUser.setRole(user.getRole());
//		User savedUser=userRepository.save(newUser);
//		return savedUser;
//		
//		}
//	@GetMapping("/users")
//	
//		public List<User> getUsers()
//		{
//		List<User>users=userRepository.findAll();
//		return users;
//		
//			
//		}
	
//	@GetMapping("/users/{userId}")
//	
//	public User getUserById(@PathVariable("userId") Integer id) throws Exception
//	{
//		User user=userService.findUserById(id);
//		return user;
//		
//		
//	}
//	
//	@PutMapping("/users/{userid}")
//	public User updateUser(@RequestBody User user,@PathVariable Integer userid) throws Exception
//	{
//		User updatedUser=userService.updateUser(user, userid);
//		return updatedUser;	
//	}
//	@PutMapping("/users/{userId1}/{userId2}")
//	public User followUserHandler(@PathVariable Integer userId1,@PathVariable Integer userId2) throws Exception
//	{
//		User user=userService.followUser(userId1, userId2);
//		return user;
//		
//	}
//	
//	@GetMapping("/users/search")	
//	public List<User>searchUser(@RequestParam("query")String query){
//		List<User> users=userService.searchUser(query);
//		return users;
//	}
//	
	
	
	

}
