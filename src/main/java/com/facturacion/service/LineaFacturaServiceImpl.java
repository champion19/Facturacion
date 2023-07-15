package com.facturacion.service;

import com.facturacion.Repository.LineaFacturaRepository;
import com.facturacion.exceptions.ResourceNotFoundException;
import com.facturacion.models.LineaFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class LineaFacturaServiceImpl implements LineaFacturaService{

    @Autowired
    private LineaFacturaRepository repository;
    @Override
    public List<LineaFactura> getAll() {
        return repository.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public LineaFactura getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("La Linea de factura con id " + id + " no se encontró"));
    }

    @Override
    @Transactional
    public LineaFactura save(LineaFactura lineaFactura) {
        return repository.save(lineaFactura);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        LineaFactura lineaFactura = repository.findById(id).orElse(null);
        if (lineaFactura == null){
            throw new ResourceNotFoundException("La linea de factura con id " + id + " no se encontró");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public LineaFactura update(LineaFactura lineaFactura) {
        LineaFactura lineaFacturaDB= this.getById(lineaFactura.getId());
        if (lineaFacturaDB== null){
            throw new ResourceNotFoundException("La Linea de factura con id " + lineaFactura.getId() + " no se encontró");
        }
        return repository.save(lineaFactura);
    }
}
