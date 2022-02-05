package com.daniel.propertymanagment.controller;

import com.daniel.propertymanagment.dto.UserDTO;
import com.daniel.propertymanagment.exception.BusinessException;
import com.daniel.propertymanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) throws BusinessException {
        userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
        if(userDTO == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }


}
