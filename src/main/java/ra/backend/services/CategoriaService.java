package ra.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.response.CategoriaResponse;

public interface CategoriaService {

    CategoriaResponse cadastrar(CategoriaRequest request);

    Page<CategoriaResponse> listarTodasCategorias(Pageable pageable);

    CategoriaResponse listarProdutosPorCategoria(String idCategoria);

    CategoriaResponse editarCategoriaBolsas(String idCategoria, CategoriaRequest request);

    String deletarCategoria(String idCategoria);
}
