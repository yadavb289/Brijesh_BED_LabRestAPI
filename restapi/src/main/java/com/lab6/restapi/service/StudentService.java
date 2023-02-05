package com.lab6.restapi.service;


import com.lab6.restapi.entity.Student;
import com.lab6.restapi.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findById(int theId) {
        return this.studentRepo.findById(theId).orElseThrow(() -> new IllegalArgumentException("inavlid id"));
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepo.findAll();
    }

    @Override
    public Student save(Student student) {
        return this.studentRepo.save(student);

    }

    @Override
    public void deleteById(int id) {
        this.studentRepo.deleteById(id);

    }

}
