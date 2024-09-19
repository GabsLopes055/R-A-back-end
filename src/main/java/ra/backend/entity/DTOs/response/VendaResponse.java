package ra.backend.entity.DTOs.response;

import jakarta.persistence.*;
import ra.backend.entity.ProdutosEntity;
import ra.backend.entity.VendaEntity;
import ra.backend.entity.enums.MetodoPagamento;
import ra.backend.entity.enums.StatusVenda;

import java.time.LocalDateTime;
import java.util.List;

public class VendaResponse {

    private String idVenda;

    private List<ProdutoResponse> produtosVendidos;

    private Double totalVenda;

    private LocalDateTime dataVenda;

    private MetodoPagamento metodoPagamento;

    private StatusVenda status;

    private Double desconto;

    public static VendaResponse toResponse(VendaEntity venda) {

        VendaResponse response = new VendaResponse();

        response.setIdVenda(venda.getIdVenda());
        response.setProdutosVendidos(ProdutoResponse.listaProdutosResponse(venda.getProdutosVendidos()));
        response.setTotalVenda(venda.getTotalVenda());
        response.setDataVenda(venda.getDataVenda());
        response.setMetodoPagamento(venda.getMetodoPagamento());
        response.setStatus(venda.getStatus());
        response.setDesconto(venda.getDesconto());

        return response;

    }

    public VendaResponse() {
    }

    public VendaResponse(String idVenda, List<ProdutoResponse> produtosVendidos, Double totalVenda, LocalDateTime dataVenda, MetodoPagamento metodoPagamento, StatusVenda status, Double desconto) {
        this.idVenda = idVenda;
        this.produtosVendidos = produtosVendidos;
        this.totalVenda = totalVenda;
        this.dataVenda = dataVenda;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
        this.desconto = desconto;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public List<ProdutoResponse> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<ProdutoResponse> produtosVendidos) {
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
