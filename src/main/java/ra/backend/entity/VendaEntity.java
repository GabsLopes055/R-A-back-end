package ra.backend.entity;

import jakarta.persistence.*;
import ra.backend.entity.enums.MetodoPagamento;
import ra.backend.entity.enums.StatusVenda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_vendas")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idVenda;

    @ManyToMany
    @JoinTable(
            name = "venda_produto",
            joinColumns = @JoinColumn(name = "id_venda"),
            inverseJoinColumns = @JoinColumn(name = "id_produto")
    )
    private List<ProdutosEntity> produtosVendidos;

    private Double totalVenda;

    private LocalDateTime dataVenda;

    private MetodoPagamento metodoPagamento;

    private StatusVenda status;

    private Double desconto;

    public VendaEntity() {
    }

    public VendaEntity(String idVenda, List<ProdutosEntity> produtosVendidos, Double totalVenda, LocalDateTime dataVenda, MetodoPagamento metodoPagamento, StatusVenda status, Double desconto) {
        this.idVenda = idVenda;
        this.produtosVendidos = produtosVendidos;
        this.totalVenda = totalVenda;
        this.dataVenda = dataVenda;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
        this.desconto = desconto;
    }

    @PrePersist
    private void PrePersist() {
        dataVenda = LocalDateTime.now();
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public List<ProdutosEntity> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<ProdutosEntity> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public void setStatus(StatusVenda status) {
        this.status = status;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
