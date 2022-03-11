package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.services.ProductoServices;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoServices service;
	
	@PostMapping
	private ResponseEntity<Producto> guardar(@RequestBody Producto c)
	{
		Producto temPer = service.create(c);
		try {
			return ResponseEntity.created(new URI("/categorias"+temPer.getId_producto())).body(temPer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Producto>> listarTodo()
	{
			return ResponseEntity.ok(service.getAllCategorias());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarCategoria(@RequestBody Producto c)
	{
		service.delete(c);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/productos/{id}")
	private ResponseEntity<Optional<Producto>> obtenerCategoria(@PathVariable ("id") Long id)
	{
			return ResponseEntity.ok(service.findById(id));
	}
}
