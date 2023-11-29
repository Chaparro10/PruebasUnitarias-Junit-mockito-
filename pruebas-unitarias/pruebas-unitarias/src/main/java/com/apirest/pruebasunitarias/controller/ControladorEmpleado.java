package com.apirest.pruebasunitarias.controller;

import com.apirest.pruebasunitarias.Exception.ResourceNoFoundException;
import com.apirest.pruebasunitarias.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.apirest.pruebasunitarias.service.IEmpleadoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// La anotación RestController indica que esta clase es un controlador de Spring que maneja solicitudes REST.
// En otras palabras, se utilizará para manejar peticiones HTTP y devolverá objetos como respuesta.
@RequestMapping ("prueba-app")
// La anotación RequestMapping se utiliza para asignar solicitudes web a métodos específicos de controlador o a clases de controlador.
// En este caso, todas las solicitudes que comienzan con "/cia-app" serán manejadas por este controlador.
@CrossOrigin (value = "http://localhost:3000")
// La anotación CrossOrigin se utiliza para permitir solicitudes desde un dominio diferente al dominio del servidor.
// En este caso, se permite la conexión desde "http://localhost:3000" (puerto típico de desarrollo de aplicaciones front-end).
public class ControladorEmpleado {


    @Autowired
    // La anotación Autowired se utiliza para realizar la inyección de dependencias.
    // En este caso, se inyecta una instancia de la interfaz IGastoServicio en esta clase.
    private IEmpleadoService empleadoService;

    //http://localhost:8080/prueba-app/emplea
    @GetMapping ("/emplea")
    public List<Empleado> obtenerEmpleados(){
        var empleados=empleadoService.listarEmpleados();
        System.out.println(empleados);
        return empleados;
    }

    //METODO PARA AGREGAR GASTOS
    //http://localhost:8080/prueba-app/emplea
    @PostMapping ("/emplea")
    public Empleado agregarEmpleados(@RequestBody Empleado empleado){
        return empleadoService.guardarEmpleado(empleado);
    }


    //METODO PARA ACTUALIZAR
    //http://localhost:8080/prueba-app/emplea/id
    @PutMapping("/emplea/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoRecibido) {
        Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
        if (empleado == null) {
            throw new ResourceNoFoundException("El id no existe: ");
        }

        // Verificar si el objeto empleadoRecibido no es nulo antes de actualizar.
        if (empleadoRecibido != null) {
            // Actualizar los campos de los empleados con la información recibida en el cuerpo de la solicitud.
            empleado.setNombre(empleadoRecibido.getNombre());
            empleado.setApellido(empleadoRecibido.getApellido());
            empleado.setEmail(empleadoRecibido.getEmail());

            // Guardar el empleado actualizado en la base de datos.
            empleado = empleadoService.guardarEmpleado(empleado);
        }

        return ResponseEntity.ok(empleado);
    }

    //BUSQUEDASSSSSS
    //METODO BUSCAR GASTOS POR ID
    @GetMapping("/emplea/{id}")
// La anotación @GetMapping indica que este método manejará solicitudes HTTP GET en la ruta "/Gastos/{id}".
    public ResponseEntity<Empleado> obtenerGastoPorId(@PathVariable Long id) {
        // El método recibe el valor de la variable de ruta {id} desde la URL y lo almacena en la variable "id".
        Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
        // Llama al método "buscarGastoPorId" del servicio "gastoServicio" para buscar un gasto por su ID y almacena el resultado en la variable "gasto".
        if (empleado == null)
            throw new ResourceNoFoundException("No se encontro el empleado id" + id);

        return ResponseEntity.ok(empleado);
        // Si se encontró el gasto, se devuelve una respuesta HTTP exitosa (código 200) con el objeto "gasto" como contenido de la respuesta.
    }


    //METODO PARA ELIMINAR
    @DeleteMapping("/emplea/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarGasto(@PathVariable Long id){
        Empleado empleado =empleadoService.buscarEmpleadoPorId(id);
        if(empleado==null) throw new ResourceNoFoundException("EL id no existe "+id);

        empleadoService.eliminarEmpleado(empleado);

        //Json {"Eliminado ": True}
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
