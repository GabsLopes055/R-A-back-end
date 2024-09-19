package ra.backend.entity.DTOs.request;

import ra.backend.entity.ProdutosEntity;
import ra.backend.entity.VendaEntity;
import ra.backend.entity.enums.MetodoPagamento;
import ra.backend.entity.enums.StatusVenda;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VendaRequest {

    private List<ProdutoRequest> produtosVendidos;

    private Double totalVenda;

    private LocalDateTime dataVenda;

    private MetodoPagamento metodoPagamento;

    private StatusVenda status;

    private Double desconto;

    public static VendaEntity toEntity(VendaRequest request) {

        VendaEntity vendaEntity = new VendaEntity();

        vendaEntity.setProdutosVendidos(request.produtosVendidos.stream().map(ProdutoRequest::toEntity).collect(Collectors.toList()));
        vendaEntity.setTotalVenda(request.getTotalVenda());
        vendaEntity.setMetodoPagamento(request.getMetodoPagamento());
        vendaEntity.setStatus(request.getStatus());
        vendaEntity.setDesconto(request.getDesconto());

        return vendaEntity;

    }

    public VendaRequest() {
    }

    public VendaRequest(List<ProdutoRequest> produtosVendidos, Double totalVenda, LocalDateTime dataVenda, MetodoPagamento metodoPagamento, StatusVenda status, Double desconto) {
        this.produtosVendidos = produtosVendidos;
        this.totalVenda = totalVenda;
        this.dataVenda = dataVenda;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
        this.desconto = desconto;
    }

    public List<ProdutoRequest> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<ProdutoRequest> produtosVendidos) {
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
