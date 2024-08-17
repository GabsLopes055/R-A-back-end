package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;
import ra.backend.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public interface UsuarioController {

    @GetMapping
    Page<UsuarioEntity> listarTodos(@RequestBody FiltroUsuarioRequest request);

}
