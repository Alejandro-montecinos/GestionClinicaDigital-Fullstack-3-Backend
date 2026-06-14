package com.ClinicaIntegral.paciente;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ClinicaIntegral.paciente.model.entities.PacienteModel;
import com.ClinicaIntegral.paciente.repositories.PacienteRepositories;
import com.ClinicaIntegral.paciente.services.PacienteService;

@ExtendWith(MockitoExtension.class) // esto es para extender las cosas de mockito a la clase ya echa 
public class PacienteServicesTest {

    @Mock
    private PacienteRepositories pacienteRepositories; // esto hace una copia del repository para no manejar los datos reales de los usuarios
    
    @InjectMocks
    private PacienteService pacienteService; // acá especificamos donde se inyectarn los mocks 

    @Test
    public void obtenerPacientePorIdTest (){

        PacienteModel paciente = new PacienteModel();
        paciente.setIdPaciente(1);
        paciente.setNombrePaciente("alejandro");

        when(pacienteRepositories.findById(1)).thenReturn(Optional.of(paciente));

        PacienteModel resultado = pacienteService.obtenerPacientePorId(1);

        Assertions.assertEquals("alejandro", resultado.getNombrePaciente());

    }

    @Test
    public void eliminarPacienteTest(){
        when(pacienteRepositories.existsById(1)).thenReturn(true);
        String resultado = pacienteService.eliminarPaciete(1);

        Assertions.assertEquals("Paciente eliminado correctamente", resultado);
    }

}
