package ra.backend.services;

import ra.backend.entity.DTOs.request.CategoriaBolsasRequest;
import ra.backend.entity.DTOs.response.CategoriaBolsasResponse;

import java.util.List;

public interface CategoriaBolsasService {

    CategoriaBolsasResponse cadastrar(CategoriaBolsasRequest request);

    List<CategoriaBolsasResponse> listarTodasCategorias();

    CategoriaBolsasResponse editarCategoriaBolsas(String idCategoria, CategoriaBolsasRequest request);

}
