package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        boolean existsByEmail(String email);

        java.util.Optional<User> findByEmail(String email);

}
