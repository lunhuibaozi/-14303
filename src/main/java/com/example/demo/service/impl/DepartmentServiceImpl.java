package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.exception.core.ValidationError;
import com.example.demo.exception.core.ValidationException;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.entity.Department;
import com.example.demo.persistence.DepartmentRepository;
import com.example.demo.service.IDepartmentService;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;

import static com.example.demo.service.impl.DepartmentStatus.ENABLED;

/**
 * Created by 胡包明 on 2017/7/21.
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department> implements IDepartmentService {


    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper){
        this.departmentMapper=departmentMapper;
    }

    public List<Department> getDepartments(){

        return departmentMapper.selectPage(
                new Page<Department>(0, 12),
                null
        );

    }
    public Department getDepartmentByID(Long departmentId){
        return departmentMapper.selectById(departmentId);
    }
    public List<Department> searchDepartment(String name){
        return departmentMapper.selectList(
                new EntityWrapper<Department>().eq("department_name",name)
        );
    }
    public Department createDepartment(Department department){
        if ( department.getId() == null ){
            throw new ValidationException( new ValidationError("id","empty") );
        }
        department.setCreatedDate( ZonedDateTime.now() );
        try {

            departmentMapper.insert(department);

        }catch (DuplicateKeyException e){
            throw new ValidationException( new ValidationError("name","not.unique") );

        }
        return  department;
    }

    public void updateDepartment(Department department){
        try {
            departmentMapper.updateById(department);
        }catch (DuplicateKeyException e) {
            throw new ValidationException(new ValidationError("name", "not.unique"));

        }

    }

    public void deleteDepartment(Long departmentId){
        departmentMapper.deleteById(departmentId);
    }

    public Department getDefaultDepartment(){
        return null;
    }
}
