package ra.backend.entity.DTOs.response;

import ra.backend.entity.CategoriaEntity;
import ra.backend.entity.DTOs.request.CategoriaRequest;

import java.util.ArrayList;
import java.util.List;

public class CategoriaResponse {

    private String idCategoria;

    private String nomeCategoria;

    private List<ProdutoResponse> produtoResponses = new ArrayList<>();

    public static CategoriaResponse toEntity(CategoriaEntity entity) {
        return new CategoriaResponse(entity.getIdCategoria(), entity.getNomeCategoria());
    }

    public static CategoriaEntity toResponse(CategoriaRequest request) {
        return new CategoriaEntity(request.getIdCategoria(), request.getNomeCategoria());
    }

    public CategoriaResponse(String idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
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

    public List<ProdutoResponse> getProdutoResponses() {
        return produtoResponses;
    }

    public void setProdutoResponses(List<ProdutoResponse> produtoResponses) {
        this.produtoResponses = produtoResponses;
    }

}
