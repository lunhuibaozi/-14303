package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.security.SecurityUtils;
import com.example.demo.service.IDepartmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by 胡包明 on 2017/7/19.
 */

@RestController
public class DepartmentController {
    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;

    }


    @GetMapping("/api/departments")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }


    @GetMapping("/api/departments/{departmentId}")
    public Department getDepartmentByID(@PathVariable Long departmentId){
        return departmentService.getDepartmentByID(departmentId);
    }

    /*@GetMapping("/api/departmentsTest")
    public void updateDepartmentsTest(){
        Department department=new Department();

        department.setName("bbb");

        departmentService.update(
                department,
                new EntityWrapper<Department>().eq("departement_name","aaa")
        );

    }

    @GetMapping("/api/departmentsTest1")
    public Department updateDepartmentsTest1(){
        Department department=new Department();
        department.setId((long)1);
        department.setName("aaa");
        department.setCode("bbb");
        department.setStatus(ENABLED);
        department.setCreatedDate(ZonedDateTime.now());
        departmentService.updateAllColumnById(department);
        return null;
    }*/

    @GetMapping("/api/departments/search")
    public List<Department> search(@RequestParam String name){
        return departmentService.searchDepartment(name);
    }



    @PostMapping("/api/departments")
    public void createDepartment(@RequestBody Department department){
        try {
            departmentService.createDepartment(department);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @PutMapping("/api/departments")
    public void updateDepartment(@RequestBody Department department){
        try {
            departmentService.updateDepartment(department);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    @DeleteMapping("/api/departments/{departmentId}")
    public void deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }


}
