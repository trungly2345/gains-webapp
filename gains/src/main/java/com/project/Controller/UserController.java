package com.project.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Model.User;
import com.project.Repository.UserRepository;



@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;


    private final UserRepository userRepository;
   
    public UserController(UserRepository userRepository){
            this.userRepository = userRepository;
    }

    // List All available users 
    @GetMapping("")
        public Iterable<User> getAllUsers(){
            return userRepository.findAll();
        }
    

    // Search the user by their specified id
    @GetMapping("/{user_id}")
    public Optional<User> getByUserID(@PathVariable(value = "user_id") Long user_id){
            return userRepository.findById(user_id);
        }


     // Create New user 
     @PostMapping
     public ResponseEntity<?> createUser(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())){
                return 
                ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email already exists");
        }


        // Encode the raw password 
        user.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        
        user.setPassword(null);
        User createdUser = userRepository.save(user);
        return ResponseEntity.ok(createdUser);
     }   
    
}
