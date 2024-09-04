package ra.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.backend.entity.DTOs.request.FiltroProdutoRequest;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.ProdutoResponse;

import java.util.List;

public interface ProdutoService {

    ProdutoResponse cadastra(ProdutoRequest request);

    Page<ProdutoResponse> listarTodosProdutos(FiltroProdutoRequest filtroProdutoRequest, Pageable pageable);

    void deletarProduto(String idProduto);

    ProdutoResponse editarProduto(String idProduto, ProdutoRequest request);

    ProdutoResponse buscarProdutoPorId(String idProduto);
}
