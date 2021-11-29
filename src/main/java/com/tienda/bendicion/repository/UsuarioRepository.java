package com.tienda.bendicion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tienda.bendicion.model.Usuario;

public interface UsuarioRepository extends  MongoRepository<Usuario, String> {
	
	List<Usuario> findByUsername(String username);
	
	List<Usuario> findByNombrecompleto(String nombrecompleto);

}
