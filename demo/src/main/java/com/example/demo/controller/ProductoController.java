package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //Ejercicio 1
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        productoService.guardar(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Ejercicio 2
    @GetMapping
    public List<Producto> ObtenerTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping(path = "{id}")
    public Producto obtenerProductoPorId(@PathVariable("id") Long id) {
        return productoService.obtener(id);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> elminarProductoPorId(@PathVariable("id") Long id) {
        productoService.elminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
