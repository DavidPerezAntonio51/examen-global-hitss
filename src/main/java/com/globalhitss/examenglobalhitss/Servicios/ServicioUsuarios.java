package com.globalhitss.examenglobalhitss.Servicios;

import com.globalhitss.examenglobalhitss.Documentos.Usuario;
import com.globalhitss.examenglobalhitss.ManejadorDeExcepciones.ExcepcionMalaPeticion;
import com.globalhitss.examenglobalhitss.ManejadorDeExcepciones.ExcepcionNoEncontrado;
import com.globalhitss.examenglobalhitss.Repositorios.RepositorioUsuarios;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuarios {
    private RepositorioUsuarios repositorioUsuarios;

    public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public List<Usuario> buscarTodosLosUsuarios(){
        return repositorioUsuarios.findAll().stream().peek(Usuario::getRoles).toList();
    }

    public Usuario buscarUsuarioPorId(String id){
        Optional<Usuario> usuarioOptional = repositorioUsuarios.findById(id);
        if(usuarioOptional.isEmpty()){
            throw new ExcepcionNoEncontrado();
        }
        return usuarioOptional.get();
    }

    public Usuario buscarUsuarioPorNombre(String nombre){
        Optional<Usuario> usuarioOptional = repositorioUsuarios.findByNombre(nombre);
        if(usuarioOptional.isEmpty()){
            throw new ExcepcionNoEncontrado();
        }
        return usuarioOptional.get();
    }

    public Usuario crearNuevoUsuario(Usuario usuario){
        return repositorioUsuarios.save(usuario);
    }

    public Usuario modificarDatosUsuario(Usuario usuario){
        if(usuario.getId()==null||usuario.getId().isBlank()){
            throw new ExcepcionMalaPeticion("El id del usuario no puede ser nulo");
        }
        if(usuario.getNombre()==null||usuario.getNombre().isBlank()){
            throw new ExcepcionMalaPeticion("El nombre del usuario no puede ser nulo");
        }
        return repositorioUsuarios.save(usuario);
    }

    public void eliminarUsuario(String id){
        repositorioUsuarios.deleteById(id);
    }

}
