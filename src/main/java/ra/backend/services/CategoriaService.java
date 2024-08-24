package ra.backend.services;

import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.response.CategoriaResponse;
import ra.backend.entity.DTOs.response.ProdutoResponse;

import java.util.List;

public interface CategoriaService {

    CategoriaResponse cadastrar(CategoriaRequest request);

    List<CategoriaResponse> listarTodasCategorias();

    List<ProdutoResponse> listarProdutosPorCategoria(String idCategoria);

    CategoriaResponse editarCategoriaBolsas(String idCategoria, CategoriaRequest request);

}
