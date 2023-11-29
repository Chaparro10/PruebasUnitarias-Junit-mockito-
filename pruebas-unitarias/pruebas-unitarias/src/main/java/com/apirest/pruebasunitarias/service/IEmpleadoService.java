package com.apirest.pruebasunitarias.service;

import com.apirest.pruebasunitarias.models.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmpleadoService {

    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorId(Long id);

    public Empleado guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
