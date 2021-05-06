package com.cts.example.reource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.example.bean.User;
import com.cts.example.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
			return  userRepository.findById(id);
				
	}
	
	@GetMapping("/users/name/{username}")
	public Optional<User> getUserByName(@PathVariable String username) {
			return  userRepository.findByUsername(username);
				
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User savedUser=userRepository.save(user);
		return savedUser;
		
	}
}
