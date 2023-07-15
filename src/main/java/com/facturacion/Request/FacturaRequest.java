package com.facturacion.Request;

import com.facturacion.models.Factura;
import com.facturacion.models.LineaFactura;
import com.facturacion.models.Producto;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.ModCheck;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FacturaRequest {
    @NotBlank
    private String nombreEmpresa;

    private double total;
    private List<LineaFacturaRequest> lineaFacturas;

    public Factura toFacturaModel(){
        List<LineaFactura>lineaFactura=new ArrayList<>();
        for(int i= 0;i<this.lineaFacturas.size();i++){
            lineaFactura.add(lineaFacturas.get(i).toLineaFacturaModal());
        }
        Factura factura = new Factura(
                this.getNombreEmpresa(),
                this.getTotal(),
                this.getLineaFacturas(),
                lineaFactura
        );
        return factura;
    }
}
