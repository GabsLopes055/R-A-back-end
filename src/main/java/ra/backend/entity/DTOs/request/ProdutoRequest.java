package ra.backend.entity.DTOs.request;

public class ProdutoRequest {

    private String nomeProduto;

    private Double precoVenda;

    private Double precoCompra;

    private Integer quantidade;

    private CategoriaRequest categoria;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String nomeProduto, Double precoVenda, Double precoCompra, Integer quantidade, CategoriaRequest categoria) {
        this.nomeProduto = nomeProduto;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.quantidade = quantidade;
        this.categoria = categoria;
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
