package com.springBoot.application.service;

import com.springBoot.application.Error.DepartmentNotFound;
import com.springBoot.application.entity.Department;
import com.springBoot.application.repository.DepartmentRepositoryI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepeartmentServiceITest {

    @Autowired
    private DepeartmentServiceI depeartmentService;

    @MockBean
    private DepartmentRepositoryI departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .deptAddress("BGL")
                .deptCode("IT")
                .deptName("IT BOON")
                .deptID(1L).build();

        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.ofNullable(department));
    }

    @Test
    public void whenValidId_thenDept_shouldFound() throws DepartmentNotFound {
         long id = 1;
         Department found = depeartmentService.fetchDeptById(id);

         assertEquals( id , found.getDeptID());

    }
}