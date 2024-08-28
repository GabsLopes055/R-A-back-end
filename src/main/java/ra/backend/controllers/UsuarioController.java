package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;

@RestController
@RequestMapping("/usuarios")
public interface UsuarioController {

    @PostMapping(value = "/listar-filtros")
    Page<UsuarioResponse> listarTodos(@RequestBody FiltroUsuarioRequest request);

    @PostMapping(value = "/cadastrar")
    ResponseEntity<UsuarioResponse> cadastrar(@RequestBody UsuarioRequest request);

    @DeleteMapping(value = "/deletarUsuario/{idUsuario}")
    ResponseEntity<String> deletarUsuario(@PathVariable(value = "idUsuario") String idUsuario);

    @PutMapping(value = "/editarUsuario/{idUsuario}")
    ResponseEntity<UsuarioResponse> editarUsuario(@RequestBody UsuarioRequest request, @PathVariable(value = "idUsuario") String idUsuario);
}
