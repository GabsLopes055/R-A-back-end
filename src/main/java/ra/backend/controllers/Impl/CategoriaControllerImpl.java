package ra.backend.controllers.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.CategoriaController;
import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.DTOs.response.CategoriaResponse;
import ra.backend.services.CategoriaService;

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
    public Page<CategoriaResponse> listarTodasCategorias(FiltroBusca paginacao) {

        Pageable pageable = PageRequest.of(paginacao.getPagina(), paginacao.getTamanhoPagina());

        return service.listarTodasCategorias(pageable);
    }

    @Override
    public ResponseEntity<CategoriaResponse> editarCategoria(String idCategoria, CategoriaRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.editarCategoriaBolsas(idCategoria, request));
    }

    @Override
    public ResponseEntity<Void> deletarCategoria(String idCategoria) {

        service.deletarCategoria(idCategoria);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<CategoriaResponse> listarProdutosPorCategorias(String idCategoria) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarProdutosPorCategoria(idCategoria));
    }

    @Override
    public ResponseEntity<CategoriaResponse> buscarCategoriaPorId(String idCategoria) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarCategoriaPorId(idCategoria));
    }


}
