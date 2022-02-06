package com.daniel.propertymanagment.repository;

import com.daniel.propertymanagment.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddresRepository extends CrudRepository<Address, Long> {
}
