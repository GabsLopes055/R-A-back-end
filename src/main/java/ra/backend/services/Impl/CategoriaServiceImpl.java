package ra.backend.services.Impl;

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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;
    private final ProdutoRepository produtoRepository;

    CategoriaServiceImpl(CategoriaRepository repository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public CategoriaResponse cadastrar(CategoriaRequest request) {

        CategoriaEntity entity = new CategoriaEntity();

        entity.setNomeCategoria(request.getNomeCategoria());

        repository.save(entity);

        return CategoriaResponse.toEntity(entity);

    }

    @Override
    public List<CategoriaResponse> listarTodasCategorias() {

        var listaCategorias = repository.findAll();

        return listaCategorias.stream().map(CategoriaResponse::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<ProdutoResponse> listarProdutosPorCategoria(String idCategoria) {

        List<ProdutosEntity> listaProdutos = produtoRepository.findProdutosByCategoriaId(idCategoria);

        return listaProdutos.stream().map(ProdutoResponse::toEntity).collect(Collectors.toList());
    }

    @Override
    public CategoriaResponse editarCategoriaBolsas(String idCategoria, CategoriaRequest request) {

        Optional<CategoriaEntity> buscarCategoria;

        buscarCategoria = Optional.ofNullable(repository.findById(idCategoria).orElseThrow( () -> new EntityNaoEncontrada("Categoria não encontrada")));

        buscarCategoria.get().setNomeCategoria(request.getNomeCategoria());

        repository.save(buscarCategoria.get());

        return CategoriaResponse.toEntity(buscarCategoria.get());

    }


}
