package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.FiltroProdutoRequest;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.CategoriaResponse;
import ra.backend.entity.DTOs.response.ProdutoResponse;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public interface ProdutoController {

    @PostMapping(value = "/listarTodosProdutos")
    Page<ProdutoResponse> listarTodosProdutos(@RequestBody FiltroProdutoRequest filtroProdutoRequest);

    @PostMapping(value = "/salvarProduto")
    ResponseEntity<ProdutoResponse> salvarProduto(@RequestBody ProdutoRequest request);

    @DeleteMapping(value = "/deletarProduto/{idProduto}")
    ResponseEntity<Void> deletarProduto(@PathVariable(value = "idProduto") String idProduto);

    @PutMapping(value = "/editarProduto/{idProduto}")
    ResponseEntity<ProdutoResponse> editarProduto(@PathVariable(value = "idProduto") String idProduto, @RequestBody ProdutoRequest request);

    @GetMapping(value = "/buscarProdutoPorId/{idProduto}")
    ResponseEntity<ProdutoResponse> buscarProdutoPorId(@PathVariable(value = "idProduto") String idProduto);

}
