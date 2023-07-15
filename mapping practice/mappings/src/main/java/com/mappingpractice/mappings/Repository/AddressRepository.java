package com.mappingpractice.mappings.Repository;

import com.mappingpractice.mappings.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
