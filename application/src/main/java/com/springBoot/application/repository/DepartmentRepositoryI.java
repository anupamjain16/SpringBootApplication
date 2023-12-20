package com.springBoot.application.repository;

import com.springBoot.application.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositoryI extends JpaRepository<Department,Long> {
}
