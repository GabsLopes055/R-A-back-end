package ra.backend.services;

import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.ProdutoResponse;

import java.util.List;

public interface ProdutoService {

    ProdutoResponse cadastra(ProdutoRequest request);

    List<ProdutoResponse> listarTodosProdutos();

}
