package com.globalhitss.examenglobalhitss.Servicios;

import com.globalhitss.examenglobalhitss.Documentos.Usuario;
import com.globalhitss.examenglobalhitss.Repositorios.RepositorioUsuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuarios {
    private RepositorioUsuarios repositorioUsuarios;

    public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public List<Usuario> buscarTodosLosUsuarios(){
        return repositorioUsuarios.findAll().stream().peek(Usuario::getRoles).toList();
    }

    public Usuario crearNuevoUsuario(Usuario usuario){
        return repositorioUsuarios.save(usuario);
    }
}
