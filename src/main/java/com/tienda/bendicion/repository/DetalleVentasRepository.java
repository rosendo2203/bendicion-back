package com.tienda.bendicion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.tienda.bendicion.model.DetalleVenta;

public interface DetalleVentasRepository extends MongoRepository<DetalleVenta, String>{

	List<DetalleVenta> findByCodigodetalleventa(Integer codigodetalleventa);
	List<DetalleVenta> findByCodigoventa(Integer codigoventa);
}
