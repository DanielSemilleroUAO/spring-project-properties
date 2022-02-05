package com.daniel.propertymanagment.converter;

import com.daniel.propertymanagment.dto.PropertyDTO;
import com.daniel.propertymanagment.entity.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public Property convertDTOtoEntity(PropertyDTO propertyDTO) {
        Property property = new Property();
        property.setTitle(propertyDTO.getTitle());
        property.setDescription(propertyDTO.getDescription());
        property.setOwnerName(propertyDTO.getOwnerName());
        property.setOwnerEmail(propertyDTO.getOwnerEmail());
        property.setAddress(propertyDTO.getAddress());
        property.setPrice(propertyDTO.getPrice());
        return property;
    }

    public PropertyDTO convertEntityToDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(property.getId());
        propertyDTO.setTitle(property.getTitle());
        propertyDTO.setDescription(property.getDescription());
        propertyDTO.setOwnerName(property.getOwnerName());
        propertyDTO.setOwnerEmail(property.getOwnerEmail());
        propertyDTO.setPrice(property.getPrice());
        propertyDTO.setAddress(property.getAddress());
        return propertyDTO;
    }

}
