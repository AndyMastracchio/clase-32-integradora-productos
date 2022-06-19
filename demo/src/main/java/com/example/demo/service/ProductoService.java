package com.example.demo.service;

import com.example.demo.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> obtenerTodos();
    Producto obtener(Long id);
    void guardar(Producto producto);
    void elminar(Long id);
}
