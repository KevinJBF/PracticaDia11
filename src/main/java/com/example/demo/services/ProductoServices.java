package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.ProductoRepository;
import com.example.demo.model.Producto;

@Service
public class ProductoServices {
	@Autowired
	private ProductoRepository repositorio;
	
	public Producto create(Producto c)
	{
		return repositorio.save(c);
	}
	
	public List<Producto> getAllCategorias()
	{
		return repositorio.findAll();
	}
	
	public void delete(Producto c)
	{
		repositorio.delete(c);
	}
	
	public Optional<Producto> findById(Long id)
	{
		return repositorio.findById(id);
	}
	
	public void actualizar(Producto c)
	{
		repositorio.save(c);
	}

}
