package com.daniel.propertymanagment.repository;

import com.daniel.propertymanagment.entity.Property;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PropertyRepository extends CrudRepository<Property, Long> {

    List<Property> findAllByUserId(Long id);

}
