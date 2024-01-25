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

    @PostMapping
    public ResponseEntity<Usuario> crearNuevoUsuario(@RequestBody Usuario usuario, HttpServletRequest request){
        Usuario usuarioCreado = servicioUsuarios.crearNuevoUsuario(usuario);
        String uriDelRecurso = request.getRequestURI().concat("/" + usuarioCreado.getId());
        return ResponseEntity.created(URI.create(uriDelRecurso)).body(usuarioCreado);
    }
}
