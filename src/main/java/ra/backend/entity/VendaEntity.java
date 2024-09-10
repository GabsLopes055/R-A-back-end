package ra.backend.entity;

import jakarta.persistence.*;

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

    private LocalDateTime  dataVenda;

    private String metodoPagamento;

    private String status; // Ex: "CONCLUIDA", "CANCELADA", "PENDENTE"

    private Double desconto;

    private Double taxa;

}
