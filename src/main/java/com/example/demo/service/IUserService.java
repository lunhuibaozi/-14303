package com.example.demo.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胡包明 on 2017/7/20.
 */
@Service
public interface IUserService  {
    List<User> selectUsersByDepartmentId(Long departmentId);
}
