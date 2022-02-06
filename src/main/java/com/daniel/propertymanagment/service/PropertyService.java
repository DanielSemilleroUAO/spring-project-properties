package com.daniel.propertymanagment.service;

import com.daniel.propertymanagment.dto.PropertyDTO;
import com.daniel.propertymanagment.entity.Property;
import com.daniel.propertymanagment.exception.BusinessException;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO) throws BusinessException;
    public List<Property> getAllProperties();
    public List<Property> getAllPropertiesByUser(Long id);
    public Property updateProperty(PropertyDTO propertyDTO, Long id);
    public Property updatePropertyDescription(PropertyDTO propertyDTO, Long id);
    public Property updatePropertyPrice(PropertyDTO propertyDTO, Long id);
    public Property deleteProperty(Long id);

}
