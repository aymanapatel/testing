package com.ayman.testcontainers.employee.respository;

import com.ayman.testcontainers.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long>
{

}