package com.globalhitss.examenglobalhitss.Repositorios;

import com.globalhitss.examenglobalhitss.Documentos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUsuarios extends MongoRepository<Usuario,String> {
    Optional<Usuario> findByNombre(String nombre);
}
