package com.facturacion.service;


import com.facturacion.Repository.FacturaRepository;
import com.facturacion.exceptions.ResourceNotFoundException;
import com.facturacion.models.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired//SCRIPT VA A BUSCAR EL COMPONENTE
    private FacturaRepository repository;//Objeto repository

    @Override
    @Transactional(readOnly = true)
    public List<Factura> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La factura con id:" + id + "no se encontro"));
    }

    @Override
    @Transactional
    public Factura save(Factura factura) {
        return repository.save(factura);
    }

    @Override
    public void deleteById(Long id) {
        /*Factura factura = repository.findById(id).orElse(null);
        if(factura == null){
            throw new ResourceNotFoundException("La factura con id: "+ id + "no se encontro");
        }
        repository.deleteById(id);
         */
    }

    @Override
    public Factura update(Factura factura) {
     return null;
    }

}
