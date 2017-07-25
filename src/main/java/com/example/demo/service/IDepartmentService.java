package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.Department;

import java.util.List;

/**
 * Created by 胡包明 on 2017/7/19.
 */

public interface IDepartmentService extends IService<Department> {
   List<Department> getDepartments();
   Department getDepartmentByID(Long departmentId);
   List<Department> searchDepartment(String name);
   Department createDepartment(Department department);
   void updateDepartment(Department department);
   void deleteDepartment(Long departmentId);
}
