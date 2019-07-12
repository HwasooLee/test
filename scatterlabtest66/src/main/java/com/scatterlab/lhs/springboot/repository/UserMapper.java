package com.scatterlab.lhs.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.scatterlab.lhs.springboot.model.User;

@Mapper
public interface UserMapper {
	User selectCityById(Long id);
    List<User> selectAllCity();
    void insertCity(User user);
}
