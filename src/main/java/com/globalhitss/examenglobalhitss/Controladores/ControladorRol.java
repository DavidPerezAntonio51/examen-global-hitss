package com.globalhitss.examenglobalhitss.Controladores;

import com.globalhitss.examenglobalhitss.Documentos.Rol;
import com.globalhitss.examenglobalhitss.Servicios.ServicioRoles;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class ControladorRol {
    private ServicioRoles servicioRoles;

    public ControladorRol(ServicioRoles servicioRoles) {
        this.servicioRoles = servicioRoles;
    }

    @PostMapping
    public ResponseEntity<Rol> crearNuevoRol(@RequestBody Rol nuevoRol, HttpServletRequest request){
        Rol rol = servicioRoles.crearNuevoRol(nuevoRol);
        String uriDelRecurso = request.getRequestURI().concat("/" + rol.getId());
        return ResponseEntity.created(URI.create(uriDelRecurso)).body(rol);
    }

    @GetMapping
    public ResponseEntity<List<Rol>> listarTodosLosRoles(){
        return ResponseEntity.ok(servicioRoles.bucarTodosLosRoles());
    }

    @GetMapping("/rol/{nombreRol}")
    public ResponseEntity<Rol> buscarRolPorNombreDeRol(@PathVariable String nombreRol){
        return ResponseEntity.ok(servicioRoles.buscarRolPorNombreRol(nombreRol));
    }

    @GetMapping("/id/{idRol}")
    public ResponseEntity<Rol> buscarRolPorId(@PathVariable String idRol){
        return ResponseEntity.ok(servicioRoles.buscarRolPorId(idRol));
    }

    @PutMapping
    public ResponseEntity<Rol> actualizarRol(@RequestBody Rol rolParaActualizar){
        return ResponseEntity.ok(servicioRoles.modificarRol(rolParaActualizar));
    }

    @DeleteMapping("/id/{idRol}")
    public ResponseEntity<?> eliminarRol(@PathVariable String idRol){
        servicioRoles.eliminarRol(idRol);
        return ResponseEntity.noContent().build();
    }
}
