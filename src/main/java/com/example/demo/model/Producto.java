package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@Column(name="id_producto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;
	
	@Column(name="producto")
	private String producto;
	
	@Column(name="fk_categoria")
	private int fk_categoria;
	
	public Producto()
	{
		
	}
	
	public Producto(int id_producto, String producto, int fk_categoria)
	{
		this.id_producto=id_producto;
		this.producto=producto;
		this.fk_categoria=fk_categoria;
	}
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getFk_categoria() {
		return fk_categoria;
	}
	public void setFk_categoria(int fk_categoria) {
		this.fk_categoria = fk_categoria;
	}
}
