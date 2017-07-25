package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胡包明 on 2017/7/21.
 */
@Service
public class UserServiceImpl implements IUserService {
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    public List<User> selectUsersByDepartmentId(Long departmentId){
        return userMapper.selectList(
                new EntityWrapper<User>().eq("departement_id",departmentId)
        );
    }
}
