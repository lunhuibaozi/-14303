package com.example.demo.service.impl;

import com.example.demo.entity.SysEnum;
import org.springframework.util.Assert;

/**
 * Created by 胡包明 on 2017/7/20.
 */
public enum DepartmentStatus implements SysEnum {
    ENABLED(1), DISABLED (0);

    private int id;

    DepartmentStatus(int id) {
        this.id = id;
    }

    public static DepartmentStatus parse(int id) {
        DepartmentStatus departmentStatus = null;
        for (DepartmentStatus status : DepartmentStatus.values()) {
            if (status.getId() == id) {
                departmentStatus = status;
            }
        }
        Assert.notNull(departmentStatus, "DepartmentStatus[id=" + id + "] not found");
        return departmentStatus;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
