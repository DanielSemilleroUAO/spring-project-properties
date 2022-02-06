package com.daniel.propertymanagment.controller;

import com.daniel.propertymanagment.dto.UserDTO;
import com.daniel.propertymanagment.exception.BusinessException;
import com.daniel.propertymanagment.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "Register", notes = "This metohd is used for user registration")
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @ApiParam(name = "userDTO", type = "userDTO", example = "user information", readOnly = true,
                    value = "user data")
            @Valid @RequestBody UserDTO userDTO) throws BusinessException {
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) throws BusinessException {
        userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
        if(userDTO == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }


}
