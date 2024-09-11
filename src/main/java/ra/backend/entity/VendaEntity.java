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

    @OneToMany
    @JoinColumn(name = "venda_id")
    private List<ProdutosEntity> produtosVendidos = new ArrayList<>();

    private Double totalVenda;

    private LocalDateTime dataVenda;

    private MetodoPagamento metodoPagamento;

    private StatusVenda status;

    private Double desconto;

    @PrePersist
    private void PrePersist() {
        dataVenda = LocalDateTime.now();
    }

}
