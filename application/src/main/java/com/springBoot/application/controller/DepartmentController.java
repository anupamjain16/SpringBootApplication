package com.springBoot.application.controller;

import ch.qos.logback.classic.Logger;
import com.springBoot.application.Error.DepartmentNotFound;
import com.springBoot.application.Error.IdNotFound;
import com.springBoot.application.entity.Department;
import com.springBoot.application.service.DepeartmentServiceI;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepeartmentServiceI depeartmentservice;

    private final Logger logger = (Logger) LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department dept)
    {
        logger.info("inside Post Mapping");

    return depeartmentservice.saveDepartment(dept);
    }

    @GetMapping("/departments")
    public List<Department> fetchhAllDept()
    {
        return depeartmentservice.fetchhAllDept();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDeptById(@PathVariable Long id) throws DepartmentNotFound {
        return depeartmentservice.fetchDeptById(id);
    }

    @DeleteMapping("departments/{id}")
    public String deleteByID(@PathVariable Long id) throws IdNotFound {
        depeartmentservice.deleteDeptByID(id);

        return "department deleted successfully";
    }

    @PutMapping("departments/{id}")
    public Department updateByID(@PathVariable("id") Long id , @RequestBody Department dept) throws DepartmentNotFound {
         return  depeartmentservice.updateByID(id , dept);
    }


}
