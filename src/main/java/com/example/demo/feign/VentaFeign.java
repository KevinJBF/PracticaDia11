package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Producto;

@FeignClient(name ="feignVentas", url="http://localhost:8080")
public interface VentaFeign {
	
	@GetMapping(path="/producto")
	List<Producto> listar();
}
