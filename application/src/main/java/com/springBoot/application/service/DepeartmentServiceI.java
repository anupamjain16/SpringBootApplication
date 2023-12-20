package com.springBoot.application.service;

import com.springBoot.application.Error.DepartmentNotFound;
import com.springBoot.application.Error.IdNotFound;
import com.springBoot.application.entity.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepeartmentServiceI {

    Department saveDepartment(Department dept);
    List<Department> fetchhAllDept();

    Department  fetchDeptById(Long id) throws DepartmentNotFound;

    void deleteDeptByID(Long id) throws IdNotFound;

   Department updateByID(Long id , Department dept) throws DepartmentNotFound;

}
