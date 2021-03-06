package com.example.demo.controller;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.RedisUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hc
 * @classname TestController
 * @description TODO
 * @date 2020/5/13
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    public UserService userService;

    @Autowired
    public RedisUtil redisUtil;
    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping("/query")
    @ResponseBody
    public User query(String name) {
        User user = userService.queryUser(name);
        return user;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {

        redisUtil.set("name", "doudou");
        String string = redisUtil.get("name");
        return string;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void saveStudent() {
        Student student = new Student();
        student.setId(33L);
        student.setUserName("hc");
        userService.saveStudent(student);
    }

    @RequestMapping("/getStudent")
    @ResponseBody
    public Student getStudent(String userName) {
        Student student = userService.getStudent(userName);
        return student;

    }

    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(String msg) {
        kafkaTemplate.send("demo", msg);
        return "success";
    }

    @KafkaListener(topics = {"hhh"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record.value());
    }
}
