package com.facturacion.Controller;

import com.facturacion.service.FacturaService;
import com.facturacion.service.ProductoService;
import com.facturacion.web.ResponseOK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<ResponseOK> getAll() {
        return ResponseOK.createResponse(HttpStatus.OK,  "Listado de productos", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOK> getById(@PathVariable Long id) {

        return ResponseOK.createResponse(HttpStatus.OK, "Persona con id: " + id, service.getById(id));
    }
}
