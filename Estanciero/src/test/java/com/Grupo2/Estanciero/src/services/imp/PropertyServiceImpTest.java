package com.Grupo2.Estanciero.src.services.imp;

import com.Grupo2.Estanciero.src.entities.PropertyEntity;
import com.Grupo2.Estanciero.src.models.Tablero;
import com.Grupo2.Estanciero.src.repositories.PropertyRepository;
import com.Grupo2.Estanciero.src.services.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PropertyServiceImpTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    private PropertyRepository propertyRepository;

    @Mock
    PropertyService propertyService;

    @MockBean
    private Tablero tablero;
    private PropertyEntity testProp;


    @BeforeEach
    void setUp() {

        testProp = new PropertyEntity();
        testProp.setProvincia("MISIONES");
        testProp.setZona("NORTE");
        testProp.setPrecioVenta(6000);
        testProp.setAlquiler(400);
        testProp.setPrecio(3600);
        testProp.setNroCasilla(33);

        propertyRepository.save(testProp);
    }

    @Test
    void getAllproperties() {

        List<PropertyEntity> result = propertyRepository.findAll();
        assertNotNull(result);
        assertEquals(30, result.size());

    }

    @Test
    void deleteAll() {
        List<PropertyEntity> existingProperties = propertyRepository.findAll();
        assertFalse(existingProperties.isEmpty());

        propertyRepository.deleteAll();

        List<PropertyEntity> deletedProperties = propertyRepository.findAll();
        assertTrue(deletedProperties.isEmpty());
        assertEquals(0, deletedProperties.size());
    }

    @Test
    void updateProperties() {

        Long propId = testProp.getId();
        int playerId = 2;

        testProp.setIdPropietario(2);
        propertyRepository.save(testProp);
        Optional<PropertyEntity> updatedProperty = propertyRepository.findById(propId);

        assertNotNull(updatedProperty);
        assertEquals(2, updatedProperty.get().getIdPropietario());

    }

    @Test
    void updatePropertiesChacras() {

        Long propId = testProp.getId();
        int cantChacras = 2;

        testProp.setCantidadChacras(2);
        propertyRepository.save(testProp);
        Optional<PropertyEntity> updatedProperty = propertyRepository.findById(propId);

        assertNotNull(updatedProperty);
        assertEquals(2, updatedProperty.get().getCantidadChacras());


    }
}