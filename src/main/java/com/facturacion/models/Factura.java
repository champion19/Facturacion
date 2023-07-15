package com.facturacion.models;
import com.facturacion.Request.LineaFacturaRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreEmpresa;
    private Date fecha;
    private double total;
    @OneToMany(mappedBy = "factura")
    @JsonIgnoreProperties(value = {"factura"})
    private List<LineaFactura> Lineas;


    public Factura(String nombreEmpresa, double total, List<LineaFacturaRequest> lineaFacturas, List<LineaFactura> lineaFactura) {
    this.nombreEmpresa=nombreEmpresa,
    this.total=total,
    this.lineaFactura=lineaFactura;
    }
}

