package com.tienda.bendicion.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tienda.bendicion.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, Integer> {
	
			//Hacer una busqueda por producto
	List<Producto> findByCodigoproducto(Integer codigoproducto);		
			//List<Usuario> findByNombre_completo(String nombre_completo);
	List<Producto> findByNombreproducto(String nombreproducto);

}
