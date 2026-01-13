package com.project.Repository;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Model.User;
import com.project.Model.Workout;
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
       // What if users want to find workout by date 
        boolean existsByName(String name);

        // find the workout by the date scheduled or created
        Workout findByDate(LocalDateTime date);

        // find the workout by the user who made it 
        Workout findByUser(Optional<User> foundUser);

} 
    

