package com.example.demo.service;

import com.example.demo.repository.ProductoRepository;
import com.example.demo.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtener(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
