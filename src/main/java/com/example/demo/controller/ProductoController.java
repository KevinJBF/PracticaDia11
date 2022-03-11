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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.services.ProductoServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoServices service;
	
	@ApiOperation(value = "Agregar un nuevo producto", notes = "obtiene el producto nuevo y la inserta en la bd")
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
	
	@ApiOperation(value = "Obtener todos productos", notes = "En una lista se agregan todos los"
			+ "registros obtenidos de la consulta para luego ser retornados por el método")
	@GetMapping
	private ResponseEntity<List<Producto>> listarTodo()
	{
			return ResponseEntity.ok(service.getAllCategorias());
	}
	
	@ApiOperation(value = "Eliminar un producto por Id", notes = "se obtiene el id del producto que se desea eliminar"
			+ "y se ejecuta dicha acción")
	@DeleteMapping
	private ResponseEntity<Void> eliminarCategoria(@RequestBody Producto c)
	{
		service.delete(c);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Obtener un producto de acuerdo a un id", notes = "obtiene un producto por el id que recibe")
	@GetMapping("/productos/{id}")
	private ResponseEntity<Optional<Producto>> obtenerCategoria(@PathVariable ("id") Long id)
	{
			return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/productos")
	private ResponseEntity<Optional<Producto>> actualizar(@RequestBody Producto c)
	{
		service.actualizar(c);
		return ResponseEntity.ok().build();
	}
}
