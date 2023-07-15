package com.facturacion.models;

import lombok.*;

import javax.persistence.*;

@Getter//crea todos los get de los atributos
@Setter//"""" """"" ""  set
@AllArgsConstructor//constructor con todos los atributos
@NoArgsConstructor//crea el constructor vacio
@Entity//esto nos mapea la clase a una tabla
@Table(name="producto")//nombre de la tabla en la DB
public class Producto {
    @Id//identificamos que atributo es el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ID SE AUTO INCREMENTA
    private Long id;

    private String nombre;

    private int descuento;

    private double Precio;

    // de Atributo a entidad
    // primero vamos desde el atributo a la entidad y luego
    // de Entidad a Atributo
}