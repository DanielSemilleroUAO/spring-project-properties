package com.daniel.propertymanagment.service;

import com.daniel.propertymanagment.dto.UserDTO;
import com.daniel.propertymanagment.exception.BusinessException;

public interface UserService {

    public UserDTO register(UserDTO userDTO);
    public UserDTO login(String email, String password) throws BusinessException;
}
