package ra.backend.controllers.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.CategoriaController;
import ra.backend.entity.DTOs.request.CategoriaBolsasRequest;
import ra.backend.entity.DTOs.response.CategoriaBolsasResponse;
import ra.backend.services.CategoriaService;

import java.util.List;

@Service
public class CategoriaControllerImpl implements CategoriaController {

    private final CategoriaService service;

    CategoriaControllerImpl(CategoriaService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<CategoriaBolsasResponse> cadastrar(CategoriaBolsasRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(request));

    }

    @Override
    public ResponseEntity<List<CategoriaBolsasResponse>> listarTodas() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodasCategorias());
    }

    @Override
    public ResponseEntity<CategoriaBolsasResponse> editarCategoria(String idCategoria, CategoriaBolsasRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.editarCategoriaBolsas(idCategoria, request));
    }

}
