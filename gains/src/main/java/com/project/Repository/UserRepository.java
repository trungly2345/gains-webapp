package com.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

        boolean existsByEmail(String email);

        User findByEmail(String email);

}
