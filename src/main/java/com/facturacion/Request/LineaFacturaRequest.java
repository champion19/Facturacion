package com.facturacion.Request;

import com.facturacion.models.LineaFactura;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LineaFacturaRequest {
    private int cantidad;

    private double total;

    @JsonProperty("/producto_id")
    private long productoId;

    public LineaFactura toLineaFacturaModal(){
        LineaFactura lineaFactura= new LineaFactura(
                this.getCantidad(),
                this.getTotal(),
                this.getProductoId()
        );
        return lineaFactura;
    }
}
