package com.example.demo.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.example.demo.service.impl.DepartmentStatus;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;


import javax.validation.constraints.NotNull;

import java.time.ZonedDateTime;

/**
 * Created by 胡包明 on 2017/7/19.
 */
@Data
@TableName("atl_department")
public class Department {
    @TableId
    @NotNull
    private Long id;
    @NotNull
    @TableField("departement_name")
    private String name;
    @NotNull
    private String code;
    @NotNull
    @TableField("department_status")
    private DepartmentStatus status;
    @NotNull
    @TableField("createdDate")
    private ZonedDateTime createdDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DepartmentStatus getStatus() {
        return status;
    }

    public void setStatus(DepartmentStatus status) {
        this.status = status;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
