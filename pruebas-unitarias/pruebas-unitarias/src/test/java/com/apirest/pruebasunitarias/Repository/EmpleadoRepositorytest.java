package com.apirest.pruebasunitarias.Repository;

import  static org.assertj.core.api.Assertions.assertThat;

import com.apirest.pruebasunitarias.models.Empleado;
import com.apirest.pruebasunitarias.repository.IEmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpleadoRepositorytest {
    @Autowired
    private IEmpleadoRepository  empleadoRepository;


    @Test
    void testGuardaEmpleado() {
        // given - dado o condición previa o configuración
        Empleado empleado = Empleado.builder()
                .nombre("pepe")
                .apellido("perez")
                .email("p1@gmail.com")
                .build();

        // when - acción o comportamiento que vamos a probar
        Empleado empleadoGuardado = empleadoRepository.save(empleado);

        // then - verificar la salida
        assertThat(empleadoGuardado).isNotNull();
        assertThat(empleadoGuardado.getId()).isGreaterThan(0);
    }

}
