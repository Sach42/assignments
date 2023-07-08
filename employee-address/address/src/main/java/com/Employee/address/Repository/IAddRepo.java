package com.Employee.address.Repository;

import com.Employee.address.Model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddRepo extends CrudRepository<Address,Long> {
}
