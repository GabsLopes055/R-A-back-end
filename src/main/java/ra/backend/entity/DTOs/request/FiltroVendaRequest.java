package ra.backend.entity.DTOs.request;

public class FiltroVendaRequest extends FiltroBusca {

    private String dataBusca;

    public FiltroVendaRequest(String dataBusca) {
        this.dataBusca = dataBusca;
    }

    public FiltroVendaRequest(Integer pagina, Integer tamanhoPagina, String dataBusca) {
        super(pagina, tamanhoPagina);
        this.dataBusca = dataBusca;
    }

    public String getDataBusca() {
        return dataBusca;
    }

    public void setDataBusca(String dataBusca) {
        this.dataBusca = dataBusca;
    }
}
