package com.springBoot.application.service;


import com.springBoot.application.Error.DepartmentNotFound;
import com.springBoot.application.Error.IdNotFound;
import com.springBoot.application.entity.Department;
import com.springBoot.application.repository.DepartmentRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DeparmentServiceImpl implements DepeartmentServiceI {

    @Autowired
    private DepartmentRepositoryI  departmentrepository;

    @Override
    public Department saveDepartment(Department dept) {


        return departmentrepository.save(dept);
    }

    @Override
    public List<Department> fetchhAllDept() {
        return departmentrepository.findAll();
    }

    @Override
    public Department fetchDeptById(Long id) throws DepartmentNotFound {

       Optional<Department> department =  departmentrepository.findById(id);

       if (!department.isPresent())
       {
           throw new DepartmentNotFound("Department not available");
       }

        return  department.get();
    }

    @Override
    public void deleteDeptByID(Long id) throws IdNotFound {

        Optional<Department> department =  departmentrepository.findById(id);

        if (!department.isPresent())
        {
            throw new IdNotFound(" Id not available");
        }


        departmentrepository.deleteById(id);

    }

    @Override
    public Department updateByID(Long id, Department dept) throws DepartmentNotFound {

        Department dept1 = fetchDeptById(id);

        dept1.setDeptAddress(dept.getDeptAddress());
        dept1.setDeptCode(dept.getDeptCode());
        dept1.setDeptName(dept.getDeptName());

        return  saveDepartment(dept);

    }


}
