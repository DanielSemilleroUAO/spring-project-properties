package com.daniel.propertymanagment.repository;

import com.daniel.propertymanagment.entity.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
}
