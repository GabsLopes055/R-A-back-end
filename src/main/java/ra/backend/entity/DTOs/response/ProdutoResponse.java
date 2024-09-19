package ra.backend.entity.DTOs.response;

import ra.backend.entity.CategoriaEntity;
import ra.backend.entity.ProdutosEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoResponse {

    private String idProduto;

    private String nomeProduto;

    private Double precoVenda;

    private Double precoCompra;

    private Integer quantidade;

    private CategoriaEntity categoria;

    public ProdutoResponse() {
    }

    public static ProdutoResponse toEntity(ProdutoResponse entity) {
        ProdutoResponse response = new ProdutoResponse();

        response.setIdProduto(entity.getIdProduto());
        response.setNomeProduto(entity.getNomeProduto());
        response.setPrecoCompra(entity.getPrecoCompra());
        response.setPrecoVenda(entity.getPrecoVenda());
        response.setQuantidade(entity.getQuantidade());

        return response;
    }

    public static ProdutoResponse toResponseDTO(ProdutosEntity produtoSalvo) {
        return new ProdutoResponse(produtoSalvo.getIdProduto(), produtoSalvo.getNomeProduto(), produtoSalvo.getPrecoVenda(), produtoSalvo.getPrecoCompra(), produtoSalvo.getQuantidade(), produtoSalvo.getCategoria());
    }

    public static List<ProdutoResponse> listaProdutosResponse(List<ProdutosEntity> produtosEntities) {
        return produtosEntities.stream().map(ProdutoResponse::toResponseDTO).collect(Collectors.toList());
    }

    public ProdutoResponse(String idProduto, String nomeProduto, Double precoVenda, Double precoCompra, Integer quantidade, CategoriaEntity categoria) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }


    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }
}
