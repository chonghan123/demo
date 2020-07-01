package com.example.demo.service.Impl;

import com.example.demo.mongo.repository.StudentRepository;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.mapper.UserMapper;
import com.example.demo.service.UserService;

/**
 * @author hc
 * @classname UserServiceImpl
 * @description TODO
 * @date 2020/7/1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public User queryUser(String name) {
        return userMapper.query(name);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(String userName) {
        return studentRepository.findByUserName(userName);
    }
}
