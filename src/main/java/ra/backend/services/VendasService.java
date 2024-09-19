package ra.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.DTOs.request.VendaRequest;
import ra.backend.entity.DTOs.response.VendaResponse;
import ra.backend.entity.VendaEntity;

import java.util.List;

public interface VendasService {

    VendaResponse cadastrarVenda(VendaRequest vendaEntity);

    Page<VendaResponse> listarTodasVendas(Pageable paginacao);

}
