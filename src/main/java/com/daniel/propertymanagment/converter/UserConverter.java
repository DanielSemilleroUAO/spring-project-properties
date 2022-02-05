package com.daniel.propertymanagment.converter;


import com.daniel.propertymanagment.dto.UserDTO;
import com.daniel.propertymanagment.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convertDTOtoEntity(UserDTO userDTO) {
        User user = new User();
        user.setOwnerName(userDTO.getOwnerName());
        user.setOwnerEmail(userDTO.getOwnerEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public UserDTO convertEntityToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setOwnerName(user.getOwnerName());
        userDTO.setOwnerEmail(user.getOwnerEmail());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }

}
