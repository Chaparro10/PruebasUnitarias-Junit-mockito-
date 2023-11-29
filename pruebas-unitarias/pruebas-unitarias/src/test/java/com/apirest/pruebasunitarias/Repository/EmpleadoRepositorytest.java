package com.apirest.pruebasunitarias.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.apirest.pruebasunitarias.models.Empleado;
import com.apirest.pruebasunitarias.repository.IEmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EmpleadoRepositorytest {
    @Autowired
    private IEmpleadoRepository empleadoRepository;


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

    @Test
    void testListarEmpleado() {

        List<Empleado> listEmpleado = empleadoRepository.findAll();
        System.out.println("Epleados:" + listEmpleado);
        //then
        assertThat(listEmpleado).isNotNull();
        assertThat(listEmpleado.size()).isEqualTo(5);
    }

    @Test
    void testListaEmpleadoXId() {
        Long idEmpleadoExistente = 1L;

        Optional<Empleado> empleadoOptional = empleadoRepository.findById(idEmpleadoExistente);
        System.out.println("Empleado id=" + empleadoOptional);
        assertThat(empleadoOptional).isNotNull();
    }

    @Test
    void testActualizarEmpleado() {
        Long idEmpleadoExistente = 5L;

        Optional<Empleado> empleadoOptional = empleadoRepository.findById(idEmpleadoExistente);

        // Verificar que el Optional no sea vacío y extraer el empleado si está presente
        assertThat(empleadoOptional).isPresent();
        Empleado empleado = empleadoOptional.get();

        System.out.println("Empleado ha actualizar" + empleadoOptional);

        // Realizar la actualización del empleado
        empleado.setNombre("NuevoNombre");
        empleado.setApellido("NuevoApellido");
        empleado.setEmail("nuevo@email.com");

        // Guardar el empleado actualizado en la base de datos
        Empleado empleadoActualizado = empleadoRepository.save(empleado);

        // Verificar que el empleado actualizado no sea nulo
        assertThat(empleadoActualizado).isNotNull();

        // Verificar que los datos del empleado se hayan actualizado correctamente
        assertThat(empleadoActualizado.getNombre()).isEqualTo("NuevoNombre");
        assertThat(empleadoActualizado.getApellido()).isEqualTo("NuevoApellido");
        assertThat(empleadoActualizado.getEmail()).isEqualTo("nuevo@email.com");


        System.out.println("Empleado actualizado" + empleadoActualizado);

    }

}
