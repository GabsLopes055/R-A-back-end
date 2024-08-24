package ra.backend.controllers.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.CategoriaController;
import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.response.CategoriaResponse;
import ra.backend.entity.DTOs.response.ProdutoResponse;
import ra.backend.services.CategoriaService;

import java.util.List;

@Service
public class CategoriaControllerImpl implements CategoriaController {

    private final CategoriaService service;

    CategoriaControllerImpl(CategoriaService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<CategoriaResponse> cadastrar(CategoriaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(request));

    }

    @Override
    public ResponseEntity<List<CategoriaResponse>> listarTodas() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodasCategorias());
    }

    @Override
    public ResponseEntity<CategoriaResponse> editarCategoria(String idCategoria, CategoriaRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.editarCategoriaBolsas(idCategoria, request));
    }

    @Override
    public ResponseEntity<List<ProdutoResponse>> listarProdutosPorCategorias(String idCategoria) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarProdutosPorCategoria(idCategoria));
    }

}
