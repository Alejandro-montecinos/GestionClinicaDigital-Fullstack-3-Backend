package com.ClinicaIntegral.Persona;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ClinicaIntegral.Persona.models.entities.PersonaModel;
import com.ClinicaIntegral.Persona.repositories.PersonaRepositories;
import com.ClinicaIntegral.Persona.services.PersonaService;

@ExtendWith(MockitoExtension.class)
public class PersonaServicesTest {

    @Mock
    private PersonaRepositories personaRepositories;

    @InjectMocks
    private PersonaService personaService;
    


    @Test
    public void buscarPersonaPorIdTest() {

        PersonaModel persona = new PersonaModel();
        persona.setIdPersona(1);
        persona.setNombre("Alejandro");

        when(personaRepositories.findById(1)).thenReturn(Optional.of(persona));

        PersonaModel resultado =personaService.buscarPersonaPorId(1);

        Assertions.assertEquals("Alejandro",resultado.getNombre());
    }

    @Test
    public void eliminarPersonaTest() {

        when(personaRepositories.existsById(1)).thenReturn(true);

        String resultado = personaService.eliminarPersona(1);

        verify(personaRepositories).deleteById(1);

        Assertions.assertEquals("Persona eliminada correctamente",resultado);
    }
}
