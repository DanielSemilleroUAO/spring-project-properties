package com.daniel.propertymanagment.controller;

import com.daniel.propertymanagment.dto.PropertyDTO;
import com.daniel.propertymanagment.entity.Property;
import com.daniel.propertymanagment.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pms.dummy}")
    private String dummy;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        System.out.println(propertyDTO.toString());
        PropertyDTO propertyResponse = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity(propertyResponse, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<?> getAllProperties(){
        System.out.println(dummy);
        return new ResponseEntity(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<?> updateProperty(@RequestBody PropertyDTO propertyDTO,  @PathVariable Long id){
        Property property = propertyService.updateProperty(propertyDTO, id);

        if(property == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<?> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,  @PathVariable Long id){
        Property property = propertyService.updatePropertyDescription(propertyDTO, id);

        if(property == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<?> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,  @PathVariable Long id){
        Property property = propertyService.updatePropertyPrice(propertyDTO, id);

        if(property == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id){
        Property property = propertyService.deleteProperty(id);

        if(property == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }


}
