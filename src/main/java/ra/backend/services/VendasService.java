package ra.backend.services;

import org.springframework.data.domain.Page;
import ra.backend.entity.DTOs.request.FiltroVendaRequest;
import ra.backend.entity.DTOs.request.VendaRequest;
import ra.backend.entity.DTOs.response.VendaResponse;

public interface VendasService {

    VendaResponse cadastrarVenda(VendaRequest vendaEntity);

    Page<VendaResponse> listarTodasVendas(FiltroVendaRequest filtroVendaRequest);

    void deletarVenda(String idVenda);

    VendaResponse buscarVendaPorId(String idVenda);

}
