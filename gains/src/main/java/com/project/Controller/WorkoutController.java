package com.project.Controller;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Model.User;
import com.project.Model.Workout;
import com.project.Repository.UserRepository;
import com.project.Repository.WorkoutRepository;

@RestController
@RequestMapping("workouts")
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    public WorkoutController(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }


    // List workouts for a specific user
    @GetMapping("/users/{user_id}")
        public Workout getWorkoutByUserId(@PathVariable(value ="user_id") Long user_id) throws RuntimeErrorException{
            // find the user to find the user_id 
            Optional <User> foundUser = userRepository.findById(user_id);
            if (foundUser.equals(null)){
                throw new RuntimeErrorException(null, "[WorkoutController.java] -> User not found!");
            }
            // find the workout by the user_id we found
            return workoutRepository.findByUser(foundUser);
        }
    



    
}
