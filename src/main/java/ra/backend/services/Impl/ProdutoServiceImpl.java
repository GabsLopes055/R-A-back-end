package ra.backend.services.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.entity.CategoriaEntity;
import ra.backend.entity.DTOs.request.FiltroProdutoRequest;
import ra.backend.entity.DTOs.request.ProdutoRequest;
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

    @Override
    public void deletarProduto(String idProduto) {

        Optional<ProdutosEntity> produto = repository.findById(idProduto);

        if (produto.isEmpty()) {
            throw new EntityNaoEncontrada("Produto não encontrado");
        } else {
            repository.delete(produto.get());
        }

    }

    @Override
    public ProdutoResponse editarProduto(String idProduto, ProdutoRequest request) {

        Optional<ProdutosEntity> produto = repository.findById(idProduto);

        Optional<CategoriaEntity> categoria = categoriaRepository.findById(request.getCategoria().getIdCategoria());

        if (produto.isEmpty()) {
            throw new EntityNaoEncontrada("Produto não encontrado");
        }

        if (categoria.isEmpty()) {
            throw new EntityNaoEncontrada("Categoria não encontrado");
        }

        produto.get().setNomeProduto(request.getNomeProduto());
        produto.get().setPrecoCompra(request.getPrecoCompra());
        produto.get().setPrecoVenda(request.getPrecoVenda());
        produto.get().setQuantidade(request.getQuantidade());
        produto.get().setCategoria(categoria.get());

        repository.save(produto.get());

        return ProdutoResponse.toResponseDTO(produto.get());

    }

    @Override
    public ProdutoResponse buscarProdutoPorId(String idProduto) {

        Optional<ProdutosEntity> produto = repository.findById(idProduto);

        if (produto.isEmpty()) {
            throw new EntityNaoEncontrada("Produto não encontrado");
        }

        return ProdutoResponse.toResponseDTO(produto.get());
    }

    private CategoriaEntity validaSeExisteCategoria(String idCategoria) {

        Optional<CategoriaEntity> categoria = Optional.ofNullable(categoriaRepository.findById(idCategoria).orElseThrow(
                () -> new EntityNaoEncontrada("Categoria não encontrada !")
        ));

        return categoria.get();

    }

    public ProdutosEntity darBaixaProduto(String idProduto) {

        // Encontra o produto pelo id
        ProdutosEntity produto = repository.findById(idProduto)
                .orElseThrow(() -> new EntityNaoEncontrada("Produto não encontrado"));

        // Verifica se o produto tem quantidade em estoque
        int quantidadeAtual = produto.getQuantidade();
        if (quantidadeAtual == 0) {
            throw new IllegalArgumentException("Produto sem estoque");
        }

        // Atualiza a quantidade e salva o produto
        produto.setQuantidade(quantidadeAtual - 1);
        repository.save(produto);

        return produto;

    }

    public void retornarProdutoAoEstoque(ProdutosEntity produto) {


        ProdutosEntity findProduto = repository.findById(produto.getIdProduto())
                .orElseThrow(() -> new EntityNaoEncontrada("Produto não encontrado"));

        int quantidadeAtual = produto.getQuantidade();

        produto.setQuantidade(quantidadeAtual + 1);
        repository.save(produto);
    }

}


