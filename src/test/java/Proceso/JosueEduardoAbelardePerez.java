package Proceso;

import Objetos.Carrera;
import Objetos.Horario;
import Objetos.RegistroAcademico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class JosueEduardoAbelardePerez {

    @InjectMocks
    private AsignarHorario asigHorario;

    @Mock
    private RegistroAcademico regisAcademico;

    @Mock
    private Carrera carrera;

    @BeforeEach
    public void inicializar(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void codigoHorarioTest(){

        try{
            when(carrera.procesarCarrera()).thenReturn(4);
            when(regisAcademico.getAnio()).thenReturn(2016);
            Horario horario = asigHorario.generarHorario(carrera, regisAcademico);
            assertEquals(140, horario.getCodigoHorario());
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }

    @Test
    public void descripcion(){
        try{
            when(regisAcademico.cheequearCarnet()).thenReturn(true);
            when(carrera.procesarCarrera()).thenReturn(4);
            when(regisAcademico.getAnio()).thenReturn(2016);
            Horario horario = asigHorario.generarHorario(carrera, regisAcademico);
            assertEquals("Nocturno", horario.getDescripcion());
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
