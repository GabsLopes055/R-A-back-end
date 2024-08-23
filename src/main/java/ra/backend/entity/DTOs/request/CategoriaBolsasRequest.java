package ra.backend.entity.DTOs.request;

public class CategoriaBolsasRequest {

    private String nomeCategoria;

    public CategoriaBolsasRequest() {
    }

    public CategoriaBolsasRequest(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
