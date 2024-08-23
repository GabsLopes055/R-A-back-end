package ra.backend.entity.DTOs.response;

import ra.backend.entity.CategoriaBolsasEntity;

public class CategoriaBolsasResponse {

    private String idCategoria;

    private String nomeCategoria;

    public static CategoriaBolsasResponse toEntity(CategoriaBolsasEntity entity) {
        return new CategoriaBolsasResponse(entity.getIdCategoria(), entity.getNomeCategoria());
    }

    public CategoriaBolsasResponse(String idCategoria, String nomeCategoria) {
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
}
