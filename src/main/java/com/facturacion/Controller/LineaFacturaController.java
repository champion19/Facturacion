package com.facturacion.Controller;

import com.facturacion.models.LineaFactura;
import com.facturacion.service.LineaFacturaService;
import com.facturacion.web.ResponseOK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class LineaFacturaController {
    @Autowired
    private LineaFacturaService service;

    @GetMapping
    public ResponseEntity<ResponseOK> getAll() {
        return ResponseOK.createResponse(HttpStatus.OK,  "Listado personas", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOK> getById(@PathVariable Long id) {

        return ResponseOK.createResponse(HttpStatus.OK, "Persona con id: " + id, service.getById(id));
    }
}
