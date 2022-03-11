package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@Column(name="id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_categoria;
	
	@Column(name="categoria")
	private String categoria;
	
	public Categoria()
	{
	}
	
	public Categoria(int id_categoria, String categoria)
	{
		this.id_categoria=id_categoria;
		this.categoria=categoria;
	}
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String nombre) {
		this.categoria = nombre;
	}
}
