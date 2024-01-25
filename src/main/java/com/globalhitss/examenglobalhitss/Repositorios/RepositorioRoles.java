package com.globalhitss.examenglobalhitss.Repositorios;

import com.globalhitss.examenglobalhitss.Documentos.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioRoles extends MongoRepository<Rol,String> {
    Optional<Rol> findByRol(String nombreRol);
}
