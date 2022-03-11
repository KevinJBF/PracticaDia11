package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.interfaces.ProductoRepository;
import com.example.demo.model.Producto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProductoControllerTest {
	
private int id = 10;
	
	@Autowired
	ProductoRepository repository;
	
	@Test
	@Order(1)
	public void testCreate()
	{
		Producto c = new Producto();
		c.setId_producto(id);
		c.setProducto("Cocina");
		c.setFk_categoria(2);
		repository.save(c);
		assertNotNull(repository.findById((long)id).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll()
	{
		List<Producto> list = repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testSingleCategori()
	{
		Producto cat = repository.findById((long)id).get();
		assertEquals(200.00, cat.getProducto());
	}
	
	@Test
	@Order(4)
	public void testUpdate()
	{
		Producto cat = repository.findById((long)id).get();
		cat.setProducto("PS4 Slim");
		repository.save(cat);
		assertNotEquals(200.00,  repository.findById((long)id).get().getProducto());
	}
	
	@Test
	@Order(5)
	public void tedtDelete()
	{
		repository.deleteById((long)id);
		assertThat(repository.existsById((long)id)).isFalse();
	}

}
