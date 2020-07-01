package com.example.demo.service;


import com.example.demo.pojo.Student;
import com.example.demo.pojo.User;

public interface UserService {

    User queryUser(String name);

    void saveStudent(Student student);

    Student getStudent(String userNam);

}
