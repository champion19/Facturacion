package com.facturacion.models;


import lombok.*;

import javax.persistence.*;

@Getter//crea todos los get de los atributos
@Setter//"""" """"" ""  set
@AllArgsConstructor//constructor con todos los atributos
@NoArgsConstructor//crea el constructor vacio
@Entity//esto nos mapea la clase a una tabla
@Table(name="LineaFactura")//nombre de la tabla en la DB
public class LineaFactura {
    @Id//identificamos que atributo es el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ID SE AUTO INCREMENTA

    private Long id;

    private int cantidad;

    private double total;
    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Factura factura;

    public LineaFactura(int cantidad, double total, long productoId) {
    this.cantidad=cantidad;
    this.total=total;

    Producto producto =new Producto();
    producto.setId(productoId);
    this.producto=producto;
    }

}
