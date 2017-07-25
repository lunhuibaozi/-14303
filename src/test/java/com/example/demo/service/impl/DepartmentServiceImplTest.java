package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.persistence.DepartmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;
import java.time.ZonedDateTime;
import static com.example.demo.service.impl.DepartmentStatus.ENABLED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 胡包明 on 2017/7/24.
 */
public class DepartmentServiceImplTest {

    private DepartmentRepository departmentRepository;

    private DepartmentMapper departmentMapper;
    Integer t;


    @Before
    public void setUp() throws Exception {
        departmentRepository= PowerMockito.mock(DepartmentRepository.class);
        departmentMapper=PowerMockito.mock(DepartmentMapper.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDepartments() throws Exception {

    }

    @Test
    public void createDepartment() throws Exception {

        //步骤： 1.准备数据
        Department department=new Department();
        department.setId((long)2);
        department.setName("人事部2");
        department.setCode("code2");
        department.setStatus(ENABLED);
        department.setCreatedDate(ZonedDateTime.now());
        //2.Mock 方法行为
        ArgumentCaptor<Department> argumentCaptor=ArgumentCaptor.forClass(Department.class);
        PowerMockito.when(departmentMapper.insert(argumentCaptor.capture())).thenReturn(t);
        //3.方法调用
        Department department1= new DepartmentServiceImpl(departmentMapper).createDepartment(department);
        String getName=  argumentCaptor.getValue().getName();
        String getCode=  argumentCaptor.getValue().getCode();
        //4.verify结果
        assertThat(argumentCaptor.getValue().getName()).isEqualTo("人事部2");

    }

}