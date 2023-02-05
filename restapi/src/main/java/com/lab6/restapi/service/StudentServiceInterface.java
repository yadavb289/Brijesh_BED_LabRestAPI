package com.lab6.restapi.service;

import com.lab6.restapi.entity.Student;

import java.util.List;

public interface StudentServiceInterface {

    public Student findById(int theId);

    public List<Student> findAll();

    public Student save(Student student);

    public void deleteById(int id);

}