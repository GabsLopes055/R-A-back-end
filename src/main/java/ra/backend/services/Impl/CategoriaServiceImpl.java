package ra.backend.services.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.entity.CategoriaEntity;
import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.response.CategoriaResponse;
import ra.backend.entity.DTOs.response.ProdutoResponse;
import ra.backend.entity.ProdutosEntity;
import ra.backend.repository.CategoriaRepository;
import ra.backend.repository.ProdutoRepository;
import ra.backend.services.CategoriaService;
import ra.backend.services.exceptions.EntityNaoEncontrada;
import ra.backend.services.exceptions.OperacaoNaoAutorizada;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;

    CategoriaServiceImpl(CategoriaRepository repository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = repository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public CategoriaResponse cadastrar(CategoriaRequest request) {

        CategoriaEntity entity = new CategoriaEntity();

        entity.setNomeCategoria(request.getNomeCategoria());

        categoriaRepository.save(entity);

        return CategoriaResponse.toEntity(entity);

    }

    @Override
    public Page<CategoriaResponse> listarTodasCategorias(Pageable pageable) {

        var listaCategorias = categoriaRepository.listarPaginado(pageable);

        return new PageImpl<>(listaCategorias.stream().map(CategoriaResponse::toEntity).collect(Collectors.toList()), pageable, listaCategorias.getTotalElements());
    }

    @Override
    public CategoriaResponse listarProdutosPorCategoria(String idCategoria) {

        CategoriaEntity categoria = categoriaRepository.findByCategoriaById(idCategoria);

        List<ProdutosEntity> listaProdutos = produtoRepository.findProdutosByCategoriaId(idCategoria);

        CategoriaResponse retorno = CategoriaResponse.toEntity(categoria);

        retorno.setProdutoResponses(listaProdutos.stream().map(ProdutoResponse::toEntity).collect(Collectors.toList()));

        return retorno;
    }

    @Override
    public CategoriaResponse editarCategoriaBolsas(String idCategoria, CategoriaRequest request) {

        Optional<CategoriaEntity> buscarCategoria;

        buscarCategoria = Optional.ofNullable(categoriaRepository.findById(idCategoria).orElseThrow(() -> new EntityNaoEncontrada("Categoria não encontrada")));

        buscarCategoria.get().setNomeCategoria(request.getNomeCategoria());

        categoriaRepository.save(buscarCategoria.get());

        return CategoriaResponse.toEntity(buscarCategoria.get());

    }

    @Override
    public String deletarCategoria(String idCategoria) {

        var deletarCategoria = categoriaRepository.findById(idCategoria);

        if (deletarCategoria.isEmpty()) {
            throw new EntityNaoEncontrada("Categoria não encontrada");
        }

        if (deletarCategoria.get().getListaProdutos().isEmpty()) {
            categoriaRepository.deleteById(deletarCategoria.get().getIdCategoria());
        } else {
            throw new OperacaoNaoAutorizada("Operação não autorizada");
        }

        return "Categoria Deletada";
    }


}
