package com.apirest.pruebasunitarias.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data // Anotación de Lombok para no tener que escribir los métodos getter, setter, equals, hashCode y toString
@NoArgsConstructor  // Crea un constructor sin argumentos
@AllArgsConstructor  // Crea un constructor con todos los argumentos
@ToString  // Genera automáticamente el método toString()
@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "email", nullable = false)
    private String email;


}
