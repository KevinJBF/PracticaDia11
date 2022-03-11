package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.feign.VentaFeign;
import com.example.demo.model.Producto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("/ventas")
public class VentaController {
	@Autowired
	private VentaFeign feignServ;
	
	@ApiOperation(value = "Obtiene todos los prodcutos con feign")
	@GetMapping(path = "/producto")
	public ResponseEntity<List<Producto>> listar()
	{
		return new ResponseEntity<>(feignServ.listar(),HttpStatus.OK);
	}
}
