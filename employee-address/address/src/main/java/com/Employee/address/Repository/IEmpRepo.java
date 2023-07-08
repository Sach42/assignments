package com.Employee.address.Repository;

import com.Employee.address.Model.Employee;
import org.springframework.data.repository.CrudRepository;



public interface IEmpRepo extends CrudRepository<Employee,Long> {
}