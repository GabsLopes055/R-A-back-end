package ra.backend.controllers.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.ProdutoController;
import ra.backend.entity.DTOs.request.FiltroProdutoRequest;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.ProdutoResponse;
import ra.backend.services.Impl.ProdutoServiceImpl;
import ra.backend.services.ProdutoService;

import java.util.List;

@Service
public class ProdutoControllerImpl implements ProdutoController {

    private final ProdutoService service;

    ProdutoControllerImpl(ProdutoServiceImpl service) {
        this.service = service;
    }


    @Override
    public Page<ProdutoResponse> listarTodosProdutos(FiltroProdutoRequest filtroProdutoRequest) {

        Pageable pageable = PageRequest.of(filtroProdutoRequest.getPagina(), filtroProdutoRequest.getTamanhoPagina());

        return service.listarTodosProdutos(filtroProdutoRequest, pageable);
    }

    @Override
    public ResponseEntity<ProdutoResponse> salvarProduto(ProdutoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastra(request));
    }

    @Override
    public ResponseEntity<String> deletarProduto(String idProduto) {

        service.deletarProduto(idProduto);

        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
    }
}
