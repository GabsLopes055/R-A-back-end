package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
