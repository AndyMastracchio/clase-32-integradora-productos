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
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //Ejercicio 1
    @PostMapping("/new")
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        productoService.guardar(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Ejercicio 2
    @GetMapping
    public List<Producto> ObtenerTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable("id") Long id) {
        return productoService.obtener(id);
    }

    // La propiedad 'path' es otra forma de definir el path variable
    // Es lo mismo que poner -> value = "/{id}" o directamente "/{id}"
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> eliminarProductoPorId(@PathVariable("id") Long id) {
        productoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
