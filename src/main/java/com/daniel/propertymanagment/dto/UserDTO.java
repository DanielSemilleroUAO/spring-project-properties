package com.daniel.propertymanagment.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message = "Owner email is mandatory")
    @NotEmpty(message = "Owner email is not empty")
    @Size(min = 1, max = 50, message = "Owner email 1 - 50")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password can not be null")
    @NotEmpty(message = "Password can not be empty")
    private String password;

    private String houseNumber;
    private String street;
    private String city;
    private String postalCode;
    private String country;
}
