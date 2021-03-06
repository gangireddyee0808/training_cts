package com.cts.example.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.example.bean.User;
import com.cts.example.exception.UserNotFoundException;
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
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
        {
            throw new UserNotFoundException("The user with id - "+id+ " does not exists");
        }
            return user; 
                
    }
    
    @GetMapping("/users/name/{username}")
    public Optional<User> getUserByName(@PathVariable String username) {
            return  userRepository.findByUsername(username);
                
    }
   
    
    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id) {
        Optional<User> user1 = userRepository.findById(id);
        if(!user1.isPresent())
        {
            throw new UserNotFoundException("The user with id - "+id+ " does not exists");
        }
        userRepository.deleteById(id);
    }
    
    
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        User savedUser=userRepository.save(user);
        return savedUser;
        
    }
    
    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        Optional<User> user1 = userRepository.findById(id);
        if(!user1.isPresent())
        {
            throw new UserNotFoundException("The user with id - "+id+ " does not exists");
        }
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}