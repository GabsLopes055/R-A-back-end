package ra.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idCategoria;

    private String nomeCategoria;

    @OneToMany(mappedBy = "categoria")
    @JsonBackReference
    private List<ProdutosEntity> listaProdutos = new ArrayList<>();

    public CategoriaEntity(){}

    public CategoriaEntity(String idCategoria, String nomeCategoria) {
    }

    public CategoriaEntity(String idCategoria, String nomeCategoria, List<ProdutosEntity> listaProdutos) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.listaProdutos = listaProdutos;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<ProdutosEntity> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutosEntity> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "idCategoria='" + idCategoria + '\'' +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                ", listaProdutos=" + listaProdutos +
                '}';
    }
}
