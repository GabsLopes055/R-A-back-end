package ra.backend.entity.DTOs.request;

import ra.backend.entity.ProdutosEntity;

public class ProdutoRequest {

    private String idProduto;

    private String nomeProduto;

    private Double precoVenda;

    private Double precoCompra;

    private Integer quantidade;

    private CategoriaRequest categoria;

    public static ProdutosEntity toEntity(ProdutoRequest request) {

        ProdutosEntity entity = new ProdutosEntity();

        entity.setIdProduto(request.getIdProduto());
        entity.setNomeProduto(request.getNomeProduto());
        entity.setQuantidade(request.getQuantidade());
        entity.setPrecoCompra(request.getPrecoCompra());
        entity.setPrecoVenda(request.getPrecoVenda());

        return entity;
    }

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nomeProduto, Double precoVenda, Double precoCompra, Integer quantidade, CategoriaRequest categoria) {
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

    public CategoriaRequest getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRequest categoria) {
        this.categoria = categoria;
    }
}
