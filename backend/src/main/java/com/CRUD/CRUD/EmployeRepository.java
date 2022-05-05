package com.CRUD.CRUD;


import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeRepository extends JpaRepository<Employee,Long> {
}
