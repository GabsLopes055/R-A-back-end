package ra.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.CategoriaBolsasRequest;
import ra.backend.entity.DTOs.response.CategoriaBolsasResponse;

import java.util.List;

@RestController
@RequestMapping("/categoriasBolsas")
public interface CategoriaController {

    @PostMapping
    ResponseEntity<CategoriaBolsasResponse> cadastrar(@RequestBody CategoriaBolsasRequest request);

    @GetMapping(value = "/listarTodasCategorias")
    ResponseEntity<List<CategoriaBolsasResponse>> listarTodas();

    @PutMapping(value = "/editarCategoria/{idCategoria}")
    ResponseEntity<CategoriaBolsasResponse> editarCategoria(@PathVariable(value = "idCategoria") String idCategoria, @RequestBody CategoriaBolsasRequest request);
}
