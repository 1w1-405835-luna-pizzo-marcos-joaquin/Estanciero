package com.Grupo2.Estanciero.src.services;

import com.Grupo2.Estanciero.src.models.Propiedades;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public interface PropertyService {

    ArrayList<Propiedades> getAllproperties();

    void updateProperties(Long propertyId, int playerId);

    void updatePropertiesChacras(Long propertyId, int chacras);

    void deleteAll();
}
