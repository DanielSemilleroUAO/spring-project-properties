package com.daniel.propertymanagment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
    private Long userId;

    @Override
    public String toString() {
        return "PropertyDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }
}
