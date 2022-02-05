package com.daniel.propertymanagment.service;

import com.daniel.propertymanagment.converter.UserConverter;
import com.daniel.propertymanagment.dto.UserDTO;
import com.daniel.propertymanagment.entity.User;
import com.daniel.propertymanagment.exception.BusinessException;
import com.daniel.propertymanagment.exception.ErrorModel;
import com.daniel.propertymanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        User user =  userRepository.save(userConverter.convertDTOtoEntity(userDTO));
        return userConverter.convertEntityToDTO(user);
    }

    @Override
    public UserDTO login(String email, String password) throws BusinessException {
        Optional<User> user = userRepository.findByOwnerEmailAndPassword(email, password);
        if(user.isPresent()){
            return userConverter.convertEntityToDTO(user.get());
        }

        List<ErrorModel> errorModels = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("INVALID_LOGIN");
        errorModel.setMessage("Incorrect email or Password");
        errorModels.add(errorModel);

        throw new BusinessException(errorModels);
    }
}
