package ra.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_produtos")
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idProduto;

}
