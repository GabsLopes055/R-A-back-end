package ra.backend.entity.DTOs.request;

import java.time.LocalDate;

public class FiltroVendaRequest extends FiltroBusca {

    private LocalDate dataInicio;

    private LocalDate dataFim;

    public FiltroVendaRequest(Integer pagina, Integer tamanhoPagina, LocalDate dataInicio, LocalDate dataFim) {
        super(pagina, tamanhoPagina);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
