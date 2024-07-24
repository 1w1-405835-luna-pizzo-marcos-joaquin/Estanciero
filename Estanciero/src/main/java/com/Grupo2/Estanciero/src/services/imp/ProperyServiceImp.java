package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.entities.PropertyEntity;
import com.Grupo2.Estanciero.src.models.Propiedades;
import com.Grupo2.Estanciero.src.repositories.PlayerRepository;
import com.Grupo2.Estanciero.src.repositories.PropertyRepository;
import com.Grupo2.Estanciero.src.services.PropertyService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProperyServiceImp implements PropertyService {


    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArrayList<Propiedades> getAllproperties() {


        List<PropertyEntity> propertiesEntity = propertyRepository.findAll();
        ArrayList<Propiedades> properties = new ArrayList<>();

        for (PropertyEntity p : propertiesEntity) {
            Propiedades property = modelMapper.map(p, Propiedades.class);
            long id = p.getId();
            int Id = (int) id;
            property.setIdPropiedad(Id);
            property.setIdPropietrio(p.getIdPropietario());
            properties.add(property);
        }
        return properties;
    }

    @Override
    public void deleteAll() {
        propertyRepository.deleteAll();
    }


    @Transactional
    @Override
    public void updateProperties(Long propertyId, int playerId) {

        Optional<PropertyEntity> propertyOptional = propertyRepository.findById(propertyId);
        if (propertyOptional.isPresent()) {
            PropertyEntity property = propertyOptional.get();

            property.setIdPropietario(playerId);
            propertyRepository.save(property);

        } else {
            throw new IllegalArgumentException("Property with ID " + propertyId + " does not exist.");
        }


    }

    @Transactional
    @Override
    public void updatePropertiesChacras(Long propertyId, int chacras) {

        Optional<PropertyEntity> propertyOptional = propertyRepository.findById(propertyId);
        if (propertyOptional.isPresent()) {
            PropertyEntity property = propertyOptional.get();

            property.setCantidadChacras(chacras);
            propertyRepository.save(property);

        } else {
            throw new IllegalArgumentException("Property with ID " + propertyId + " does not exist.");
        }
    }
}
