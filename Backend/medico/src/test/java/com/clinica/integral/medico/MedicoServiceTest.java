package com.clinica.integral.medico;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.clinica.integral.medico.models.entities.Medico;
import com.clinica.integral.medico.repositories.MedicoRepository;
import com.clinica.integral.medico.services.MedicoService;

@ExtendWith(MockitoExtension.class)
public class MedicoServiceTest {

    @Mock
    private MedicoRepository medicoRepo;

    @InjectMocks
    private MedicoService medicoService;

    @Test
    public void obtenerMedicoPorIdTest() {

        Medico medico = new Medico();
        medico.setIdMedico(1);
        medico.setNombreMedico("Dr. Alejandro");

        when(medicoRepo.findById(1)).thenReturn(Optional.of(medico));

        Medico resultado = medicoService.obtenerMedicoPorId(1);

        Assertions.assertEquals("Dr. Alejandro",resultado.getNombreMedico());
    }

    @Test
    public void eliminarMedicoTest() {

        Medico medico = new Medico();
        medico.setIdMedico(1);

        when(medicoRepo.findById(1)).thenReturn(Optional.of(medico));

        String resultado = medicoService.eliminarMedico(1);

        verify(medicoRepo).deleteById(1);

        Assertions.assertEquals("Médico eliminado",resultado);
    }
    
}
