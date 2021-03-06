package com.tienda.bendicion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

import com.tienda.bendicion.model.Venta;

public interface VentaRepository extends MongoRepository<Venta, String> {

	List<Venta> findByConsecutivo(Integer consecutivo);

	List<Venta> findByCedulacliente(Integer cedulacliente);

}
