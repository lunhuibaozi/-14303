package com.example.demo.persistence;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by 胡包明 on 2017/7/25.
 */
@NoRepositoryBean
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
