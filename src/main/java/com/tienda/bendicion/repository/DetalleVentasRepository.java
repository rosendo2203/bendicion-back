package com.tienda.bendicion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

import com.tienda.bendicion.model.DetalleVenta;

public interface DetalleVentasRepository extends MongoRepository<DetalleVenta, String>{
	
	List<DetalleVenta> findByCodigoproducto(String codigoproducto);
	Optional<DetalleVenta> findById(String id);
	
}
