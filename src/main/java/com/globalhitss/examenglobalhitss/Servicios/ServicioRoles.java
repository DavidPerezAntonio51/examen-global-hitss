package com.globalhitss.examenglobalhitss.Servicios;

import com.globalhitss.examenglobalhitss.Documentos.Rol;
import com.globalhitss.examenglobalhitss.ManejadorDeExcepciones.ExcepcionMalaPeticion;
import com.globalhitss.examenglobalhitss.ManejadorDeExcepciones.ExcepcionNoEncontrado;
import com.globalhitss.examenglobalhitss.Repositorios.RepositorioRoles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRoles {
    private RepositorioRoles repositorioRoles;

    public ServicioRoles(RepositorioRoles repositorioRoles) {
        this.repositorioRoles = repositorioRoles;
    }

    public List<Rol> bucarTodosLosRoles(){
        return repositorioRoles.findAll();
    }
    public Rol buscarRolPorNombreRol(String rol){
        Optional<Rol> rolOptional = repositorioRoles.findByRol(rol);
        if(rolOptional.isEmpty()){
            throw new ExcepcionNoEncontrado();
        }
        return rolOptional.get();
    }
    public Rol buscarRolPorId(String id){
        Optional<Rol> rolOptional = repositorioRoles.findById(id);
        if(rolOptional.isEmpty()){
            throw new ExcepcionNoEncontrado();
        }
        return rolOptional.get();
    }
    public Rol crearNuevoRol(Rol nuevoRol){
        return repositorioRoles.save(nuevoRol);
    }
    public Rol modificarRol(Rol rolModificado){
        if(rolModificado.getId()==null||rolModificado.getId().isBlank()){
            throw new ExcepcionMalaPeticion("El id del rol no esta presente");
        }
        if(rolModificado.getRol().isBlank()){
            throw new ExcepcionMalaPeticion("El rol no puede estar vacio");
        }
        return repositorioRoles.save(rolModificado);
    }
    public void eliminarRol(String id){
        repositorioRoles.deleteById(id);
    }
}
