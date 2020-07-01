package com.example.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.example.demo.mybatis.pojo.User;

@Component
@Mapper
public interface UserMapper {

  User query(@Param("name") String name);
}
