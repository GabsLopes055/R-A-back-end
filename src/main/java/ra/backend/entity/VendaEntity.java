package ra.backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_vendas")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idVenda;

    private List<ProdutosEntity> produtoVendido = new ArrayList<>();

    private Double totalVenda;

}
