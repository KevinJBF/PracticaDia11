package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
