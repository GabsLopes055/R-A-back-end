package ra.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_produtos")
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idProduto;

    private String nomeProduto;

    private Double precoVenda;

    private Double precoCompra;

    private Integer quantidade;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;


    @ManyToMany(mappedBy = "produtosVendidos")
    @JsonBackReference
    private List<VendaEntity> vendas;

    public ProdutosEntity() {
    }

    public ProdutosEntity(String idProduto, String nomeProduto, Double precoVenda, Double precoCompra, Integer quantidade, CategoriaEntity categoria) {
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

    public List<VendaEntity> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaEntity> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "ProdutosEntity{" +
                "idProduto='" + idProduto + '\'' +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", precoVenda=" + precoVenda +
                ", precoCompra=" + precoCompra +
                ", quantidade=" + quantidade +
                ", categoria=" + categoria +
                '}';
    }
}
