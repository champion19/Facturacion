package com.facturacion.Controller;

import com.facturacion.Request.FacturaRequest;
import com.facturacion.models.Factura;
import com.facturacion.service.FacturaService;
import com.facturacion.web.ResponseOK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController//
@RequestMapping("/factura")//
public class FacturaController {

    @Autowired
    private FacturaService service;

    @GetMapping
    public ResponseEntity<ResponseOK> getAll() {
        return ResponseOK.createResponse(HttpStatus.OK,  "Listado facturas", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOK> getById(@PathVariable Long id) {

        return ResponseOK.createResponse(HttpStatus.OK, "Factura con id: " + id, service.getById(id));
    }
    @PostMapping
    public ResponseEntity<ResponseOK> save(@RequestBody @Valid FacturaRequest facturaRequest) {
        Factura facturaBD = service.save(facturaRequest.toFacturaModel());
        return ResponseOK.createResponse(HttpStatus.OK, "Factura nueva creada ", facturaBD);
    }
}
