package ra.backend.services.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.entity.CategoriaEntity;
import ra.backend.entity.DTOs.request.CategoriaRequest;
import ra.backend.entity.DTOs.request.FiltroProdutoRequest;
import ra.backend.entity.DTOs.request.ProdutoRequest;
import ra.backend.entity.DTOs.response.CategoriaResponse;
import ra.backend.entity.DTOs.response.ProdutoResponse;
import ra.backend.entity.ProdutosEntity;
import ra.backend.repository.CategoriaRepository;
import ra.backend.repository.ProdutoRepository;
import ra.backend.services.ProdutoService;
import ra.backend.services.exceptions.EntityNaoEncontrada;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;


    ProdutoServiceImpl(ProdutoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    /*
     * esse metodo realiza o cadastro de um produto juntamente com a categoria.
     * */
    @Override
    public ProdutoResponse cadastra(ProdutoRequest request) {

        ProdutosEntity produto = new ProdutosEntity();

        produto.setNomeProduto(request.getNomeProduto());
        produto.setPrecoCompra(request.getPrecoCompra());
        produto.setPrecoVenda(request.getPrecoVenda());
        produto.setQuantidade(request.getQuantidade());

        produto.setCategoria(validaSeExisteCategoria(request.getCategoria().getIdCategoria()));

        var produtoSalvo = repository.save(produto);

        return ProdutoResponse.toResponseDTO(produtoSalvo);
    }

    @Override
    public Page<ProdutoResponse> listarTodosProdutos(FiltroProdutoRequest filtroProdutoRequest, Pageable pageable) {

        Page<ProdutosEntity> listaProdutos = repository.listarPorFiltro(filtroProdutoRequest, pageable);

        return new PageImpl<>(listaProdutos.stream().map(ProdutoResponse::toResponseDTO).collect(Collectors.toList()), pageable, listaProdutos.getTotalElements());
    }

    private CategoriaEntity validaSeExisteCategoria(String idCategoria) {

        Optional<CategoriaEntity> categoria = Optional.ofNullable(categoriaRepository.findById(idCategoria).orElseThrow(
                () -> new EntityNaoEncontrada("Categoria não encontrada !")
        ));

        return categoria.get();

    }
}


