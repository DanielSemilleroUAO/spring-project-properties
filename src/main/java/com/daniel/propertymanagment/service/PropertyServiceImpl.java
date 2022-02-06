package com.daniel.propertymanagment.service;

import com.daniel.propertymanagment.converter.PropertyConverter;
import com.daniel.propertymanagment.dto.PropertyDTO;
import com.daniel.propertymanagment.entity.Property;
import com.daniel.propertymanagment.entity.User;
import com.daniel.propertymanagment.exception.BusinessException;
import com.daniel.propertymanagment.exception.ErrorModel;
import com.daniel.propertymanagment.repository.AddresRepository;
import com.daniel.propertymanagment.repository.PropertyRepository;
import com.daniel.propertymanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddresRepository addresRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) throws BusinessException {

        Optional<User> user = userRepository.findById(propertyDTO.getUserId());
        if(user.isPresent()){
            Property property = propertyConverter.convertDTOtoEntity(propertyDTO);
            property.setUser(user.get());
            Property propertyResponse = propertyRepository.save(property);
            return propertyConverter.convertEntityToDTO(propertyResponse);
        }

        List<ErrorModel> errorModels = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("INVALID_USER_ID");
        errorModel.setMessage("User dont exist");
        errorModels.add(errorModel);

        throw new BusinessException(errorModels);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Property> getAllProperties() {
        return (List<Property>) propertyRepository.findAll();
    }

    @Override
    public List<Property> getAllPropertiesByUser(Long id) {
        return propertyRepository.findAllByUserId(id);
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
