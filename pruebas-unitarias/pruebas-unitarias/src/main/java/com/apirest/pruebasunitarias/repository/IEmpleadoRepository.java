package com.apirest.pruebasunitarias.repository;

import com.apirest.pruebasunitarias.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
    Optional<Empleado> findByEmail(String email);
}
