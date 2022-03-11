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

import com.example.demo.model.Categoria;
import com.example.demo.services.CategoriaServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaServices service;
	
	@ApiOperation(value = "Agregar una categoría", notes = "obtiene la categoría y la inserta en la bd")
	@PostMapping
	private ResponseEntity<Categoria> guardar(@RequestBody Categoria c)
	{
		Categoria temPer = service.create(c);
		try {
			return ResponseEntity.created(new URI("/categorias"+temPer.getId_categoria())).body(temPer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@ApiOperation(value = "Obtener todas las categorías", notes = "En una lista se agregan todos los"
			+ "registros obtenidos de la consulta para luego ser retornados por el método")
	@GetMapping
	private ResponseEntity<List<Categoria>> listarTodo()
	{
			return ResponseEntity.ok(service.getAllCategorias());
	}
	
	@ApiOperation(value = "Eliminar una categoria de acuerdo al Id", notes = "se obtiene el id de la categoría que se desea eliminar"
			+ "y se ejecuta dicha acción")
	@DeleteMapping
	private ResponseEntity<Void> eliminarCategoria(@RequestBody Categoria c)
	{
		service.delete(c);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Obtener una categoria de acuerdo a un", notes = "obtiene una categoría por el id que recibe")
	@GetMapping("/categorias/{id}")
	private ResponseEntity<Optional<Categoria>> obtenerCategoria(@PathVariable ("id") Long id)
	{
			return ResponseEntity.ok(service.findById(id));
	}
	
}
