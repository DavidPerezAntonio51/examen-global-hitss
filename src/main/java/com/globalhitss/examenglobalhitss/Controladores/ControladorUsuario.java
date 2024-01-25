package com.globalhitss.examenglobalhitss.Controladores;

import com.globalhitss.examenglobalhitss.Documentos.Usuario;
import com.globalhitss.examenglobalhitss.Servicios.ServicioUsuarios;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {
    private ServicioUsuarios servicioUsuarios;

    public ControladorUsuario(ServicioUsuarios servicioUsuarios) {
        this.servicioUsuarios = servicioUsuarios;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios(){
        return ResponseEntity.ok(servicioUsuarios.buscarTodosLosUsuarios());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable String id){
        return ResponseEntity.ok(servicioUsuarios.buscarUsuarioPorId(id));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Usuario> buscarUsuarioPorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(servicioUsuarios.buscarUsuarioPorNombre(nombre));
    }

    @PostMapping
    public ResponseEntity<Usuario> crearNuevoUsuario(@RequestBody Usuario usuario, HttpServletRequest request){
        Usuario usuarioCreado = servicioUsuarios.crearNuevoUsuario(usuario);
        String uriDelRecurso = request.getRequestURI().concat("/" + usuarioCreado.getId());
        return ResponseEntity.created(URI.create(uriDelRecurso)).body(usuarioCreado);
    }

    @PutMapping
    public ResponseEntity<Usuario> modificarDatosDelUsuario(@RequestBody Usuario usuarioModificado){
        return ResponseEntity.ok(servicioUsuarios.modificarDatosUsuario(usuarioModificado));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String id){
        servicioUsuarios.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
