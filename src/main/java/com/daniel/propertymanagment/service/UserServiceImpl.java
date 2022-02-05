package com.daniel.propertymanagment.service;

import com.daniel.propertymanagment.converter.UserConverter;
import com.daniel.propertymanagment.dto.UserDTO;
import com.daniel.propertymanagment.entity.User;
import com.daniel.propertymanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserDTO login(String email, String password) {
        return null;
    }
}
