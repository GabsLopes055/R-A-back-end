package ra.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.response.CategoriaResponse;
import ra.backend.entity.DTOs.response.ProdutoResponse;

import java.util.List;

@RestController
@RequestMapping("/categoriasBolsas")
public interface CategoriaController {

    @PostMapping
    ResponseEntity<CategoriaResponse> cadastrar(@RequestBody CategoriaRequest request);

    @GetMapping(value = "/listarTodasCategorias")
    ResponseEntity<List<CategoriaResponse>> listarTodas();

    @PutMapping(value = "/editarCategoria/{idCategoria}")
    ResponseEntity<CategoriaResponse> editarCategoria(@PathVariable(value = "idCategoria") String idCategoria, @RequestBody CategoriaRequest request);

    @GetMapping(value = "/listarProdutosPorCategoria/{idCategoria}")
    ResponseEntity<List<ProdutoResponse>> listarProdutosPorCategorias(@PathVariable(value = "idCategoria") String idCategoria);
}
