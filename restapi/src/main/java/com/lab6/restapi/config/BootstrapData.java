package com.lab6.restapi.config;

import com.lab6.restapi.entity.Role;
import com.lab6.restapi.entity.Student;
import com.lab6.restapi.entity.User;
import com.lab6.restapi.repo.StudentRepo;
import com.lab6.restapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class BootstrapData {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Dummy data for student table
    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initializeData(ApplicationReadyEvent readyEvent) {
        Student Suresh = new Student("Suresh", "Reddy", "B.Tech", "India");
        Student Marali = new Student("Marali", "Mohan", "B.Arch", "Canada");
        Student Daniel = new Student("Daniel", "Denson", "B.Tech", "New Zealand");
        Student Tanya = new Student("Tanya", "Gupta", "B.Com", "USA");

        this.studentRepo.save(Suresh);
        this.studentRepo.save(Marali);
        this.studentRepo.save(Daniel);
        this.studentRepo.save(Tanya);
    }


    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initializeUsersData(ApplicationReadyEvent readyEvent) {
        User brijesh = new User("brijesh", passwordEncoder.encode("password"));
        User akash = new User("akash", passwordEncoder.encode("password"));

        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        brijesh.addRole(adminRole);

        akash.addRole(userRole);

        this.userRepo.save(brijesh);
        this.userRepo.save(akash);
    }
}
