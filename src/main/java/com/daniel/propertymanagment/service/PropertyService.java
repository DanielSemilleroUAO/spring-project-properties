package com.daniel.propertymanagment.service;

import com.daniel.propertymanagment.dto.PropertyDTO;
import com.daniel.propertymanagment.entity.Property;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<Property> getAllProperties();
    public Property updateProperty(PropertyDTO propertyDTO, Long id);
    public Property updatePropertyDescription(PropertyDTO propertyDTO, Long id);
    public Property updatePropertyPrice(PropertyDTO propertyDTO, Long id);
    public Property deleteProperty(Long id);

}
