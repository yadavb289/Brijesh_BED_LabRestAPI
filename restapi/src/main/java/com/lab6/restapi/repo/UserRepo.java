package com.lab6.restapi.repo;

import com.lab6.restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    //Adding a find by username method
    Optional<User> findByUsername(String username);

}
