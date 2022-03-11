package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.interfaces.CategoriaRepository;
import com.example.demo.model.Categoria;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CategoriaControllerTest {
	
	private int id = 4;
	
	@Autowired
	CategoriaRepository repository;
	
	@Test
	@Order(1)
	public void testCreate()
	{
		Categoria c = new Categoria();
		c.setId_categoria(id);
		c.setCategoria("Cocina");
		repository.save(c);
		assertNotNull(repository.findById((long)id).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll()
	{
		List<Categoria> list = repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testSingleCategori()
	{
		Categoria cat = repository.findById((long)id).get();
		assertEquals(200.00, cat.getCategoria());
	}
	
	@Test
	@Order(4)
	public void testUpdate()
	{
		Categoria cat = repository.findById((long)id).get();
		cat.setCategoria("Zapatos");
		repository.save(cat);
		assertNotEquals(200.00,  repository.findById((long)id).get().getCategoria());
	}
	
	@Test
	@Order(5)
	public void tedtDelete()
	{
		repository.deleteById((long)id);
		assertThat(repository.existsById((long)id)).isFalse();
	}
}
