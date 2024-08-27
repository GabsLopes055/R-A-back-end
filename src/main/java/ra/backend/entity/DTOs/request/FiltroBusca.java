package ra.backend.entity.DTOs.request;

public class FiltroBusca {

    private Integer pagina;
    private Integer tamanhoPagina;

    public FiltroBusca() {
        this(null,null);
    }

    public FiltroBusca(Integer pagina, Integer tamanhoPagina) {
        this.pagina = pagina;
        this.tamanhoPagina = tamanhoPagina;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(Integer tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }
}
