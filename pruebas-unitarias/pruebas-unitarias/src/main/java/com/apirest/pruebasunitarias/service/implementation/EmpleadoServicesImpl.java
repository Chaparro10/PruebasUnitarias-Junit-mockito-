package com.apirest.pruebasunitarias.service.implementation;

import com.apirest.pruebasunitarias.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import com.apirest.pruebasunitarias.repository.IEmpleadoRepository;
import com.apirest.pruebasunitarias.service.IEmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpleadoServicesImpl implements IEmpleadoService {

    //Inyeccion de Dependencia
    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Long id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        return empleado;
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado) ;
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
            empleadoRepository.delete(empleado);
    }
}
