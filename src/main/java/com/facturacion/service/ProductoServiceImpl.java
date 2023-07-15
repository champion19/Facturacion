package com.facturacion.service;

import com.facturacion.Repository.ProductoRepository;
import com.facturacion.exceptions.ResourceNotFoundException;
import com.facturacion.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl  implements  ProductoService{
   private  ProductoRepository repository;

    @Override
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("El producto con id:" + id+"no se encontro"));
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        Producto producto = repository.findById(id).orElse(null);
        if(producto == null){
            throw new ResourceNotFoundException("El producto con id: "+ id + "no se encontro");
        }
        repository.deleteById(id);

    }

    @Override
    public Producto update(Producto producto) {
        Producto paisDB = this.getById(producto.getId());
        if(paisDB==null){
            throw new ResourceNotFoundException("El Pais con id: " + producto.getId() + "no se encontro");
        }
        return  repository.save(producto);
    }
}
