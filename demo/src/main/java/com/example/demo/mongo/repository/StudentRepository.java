package com.example.demo.mongo.repository;

import com.example.demo.pojo.Student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    Student findByUserName(String userName);
}
