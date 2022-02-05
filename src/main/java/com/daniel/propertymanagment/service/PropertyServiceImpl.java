package com.daniel.propertymanagment.service;

import com.daniel.propertymanagment.converter.PropertyConverter;
import com.daniel.propertymanagment.dto.PropertyDTO;
import com.daniel.propertymanagment.entity.Property;
import com.daniel.propertymanagment.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        Property property = propertyConverter.convertDTOtoEntity(propertyDTO);
        Property propertyResponse = propertyRepository.save(property);

        return propertyConverter.convertEntityToDTO(propertyResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Property> getAllProperties() {
        return (List<Property>) propertyRepository.findAll();
    }

    @Override
    public Property updateProperty(PropertyDTO propertyDTO, Long id) {
       Optional<Property> property = propertyRepository.findById(id);

       if(property.isPresent()){
           Property propertyOriginal = property.get();
           propertyOriginal.setTitle(propertyDTO.getTitle());
           propertyOriginal.setDescription(propertyDTO.getDescription());
           propertyOriginal.setOwnerName(propertyDTO.getOwnerName());
           propertyOriginal.setOwnerEmail(propertyDTO.getOwnerEmail());
           propertyOriginal.setAddress(propertyDTO.getAddress());
           propertyOriginal.setPrice(propertyDTO.getPrice());
           propertyRepository.save(propertyOriginal);

           return propertyOriginal;
       }

       return null;
    }

    @Override
    public Property updatePropertyDescription(PropertyDTO propertyDTO, Long id) {
        Optional<Property> property = propertyRepository.findById(id);

        if(property.isPresent()){
            Property propertyOriginal = property.get();
            propertyOriginal.setDescription(propertyDTO.getDescription());
            propertyRepository.save(propertyOriginal);
            return propertyOriginal;
        }
        return null;
    }

    @Override
    public Property updatePropertyPrice(PropertyDTO propertyDTO, Long id) {
        Optional<Property> property = propertyRepository.findById(id);

        if(property.isPresent()){
            Property propertyOriginal = property.get();
            propertyOriginal.setPrice(propertyDTO.getPrice());
            propertyRepository.save(propertyOriginal);
            return propertyOriginal;
        }

        return null;
    }

    @Override
    public Property deleteProperty(Long id) {
        Optional<Property> property = propertyRepository.findById(id);

        if(property.isPresent()){
            propertyRepository.deleteById(id);
            return property.get();
        }

        return null;
    }
}
