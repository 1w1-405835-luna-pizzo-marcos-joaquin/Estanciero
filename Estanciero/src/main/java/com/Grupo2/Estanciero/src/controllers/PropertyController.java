package com.Grupo2.Estanciero.src.controllers;

import com.Grupo2.Estanciero.src.dtos.PropertyDto;
import com.Grupo2.Estanciero.src.models.Propiedades;
import com.Grupo2.Estanciero.src.services.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<PropertyDto>> getProperties() {

        ArrayList<PropertyDto> propertiesDto = new ArrayList<>();
        ArrayList<Propiedades> properties = propertyService.getAllproperties();

        for (Propiedades p : properties) {
            PropertyDto propertyDto = modelMapper.map(p, PropertyDto.class);
            propertiesDto.add(propertyDto);
        }

        return ResponseEntity.ok(propertiesDto);
    }

    @DeleteMapping("/deleteAll")
    public void delete() {
        propertyService.deleteAll();
    }

}
