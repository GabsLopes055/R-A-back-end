package ra.backend.controllers.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.ProdutoController;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.ProdutoResponse;
import ra.backend.services.Impl.ProdutoServiceImpl;

import java.util.List;

@Service
public class ProdutoControllerImpl implements ProdutoController {

    private final ProdutoServiceImpl service;

    ProdutoControllerImpl(ProdutoServiceImpl service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<List<ProdutoResponse>> listarTodosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosProdutos());
    }

    @Override
    public ResponseEntity<ProdutoResponse> salvarProduto(ProdutoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastra(request));
    }
}
