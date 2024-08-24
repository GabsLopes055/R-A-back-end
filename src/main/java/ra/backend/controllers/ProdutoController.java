package ra.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.ProdutoResponse;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public interface ProdutoController {

    @GetMapping(value = "/listarTodosProdutos")
    ResponseEntity<List<ProdutoResponse>> listarTodosProdutos();

    @PostMapping(value = "/salvarProduto")
    ResponseEntity<ProdutoResponse> salvarProduto(@RequestBody ProdutoRequest request);

}
