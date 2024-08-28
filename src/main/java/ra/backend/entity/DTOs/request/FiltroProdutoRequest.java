package ra.backend.entity.DTOs.request;

public class FiltroProdutoRequest extends FiltroBusca {

    private String tipoProduto;

    public FiltroProdutoRequest(Integer pagina, Integer tamanhoPagina, String tipoProduto) {
        super(pagina, tamanhoPagina);
        this.tipoProduto = tipoProduto;
    }

    public FiltroProdutoRequest() {
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}


