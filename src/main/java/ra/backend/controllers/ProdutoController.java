package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.FiltroProdutoRequest;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.ProdutoResponse;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public interface ProdutoController {

    @PostMapping(value = "/listarTodosProdutos")
    Page<ProdutoResponse> listarTodosProdutos(@RequestBody FiltroProdutoRequest filtroProdutoRequest);

    @PostMapping(value = "/salvarProduto")
    ResponseEntity<ProdutoResponse> salvarProduto(@RequestBody ProdutoRequest request);


}
