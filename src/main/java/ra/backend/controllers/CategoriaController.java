package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.DTOs.response.CategoriaResponse;

@RestController
@RequestMapping("/categoriasBolsas")
public interface CategoriaController {

    @PostMapping(value = "/cadastrarCategoria")
    ResponseEntity<CategoriaResponse> cadastrar(@RequestBody CategoriaRequest request);

    @PostMapping(value = "/listarTodasCategorias")
    Page<CategoriaResponse> listarTodasCategorias(@RequestBody FiltroBusca paginacao);

    @PutMapping(value = "/editarCategoria/{idCategoria}")
    ResponseEntity<CategoriaResponse> editarCategoria(@PathVariable(value = "idCategoria") String idCategoria, @RequestBody CategoriaRequest request);

    @DeleteMapping(value = "/deletarCategoria/{idCategoria}")
    ResponseEntity<Void> deletarCategoria(@PathVariable(value = "idCategoria") String idCategoria);

    @GetMapping(value = "/listarProdutosPorCategoria/{idCategoria}")
    ResponseEntity<CategoriaResponse> listarProdutosPorCategorias(@PathVariable(value = "idCategoria") String idCategoria);

    @GetMapping(value = "/buscarCategoriaPorId/{idCategoria}")
    ResponseEntity<CategoriaResponse> buscarCategoriaPorId(@PathVariable(value = "idCategoria") String idCategoria);

}
