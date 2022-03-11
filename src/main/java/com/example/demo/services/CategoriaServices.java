package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.CategoriaRepository;
import com.example.demo.model.Categoria;

@Service
public class CategoriaServices {
	@Autowired
	private CategoriaRepository repositorio;
	
	public Categoria create(Categoria c)
	{
		return repositorio.save(c);
	}
	
	public List<Categoria> getAllCategorias()
	{
		return repositorio.findAll();
	}
	
	public void delete(Categoria c)
	{
		repositorio.delete(c);
	}
	
	public Optional<Categoria> findById(Long id)
	{
		return repositorio.findById(id);
	}
	
	public void actualizar(Categoria c)
	{
		repositorio.save(c);
	}
}
