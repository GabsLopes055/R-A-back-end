package ra.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.VendaEntity;

import java.util.List;

public interface VendasService {

    VendaEntity cadastrarVenda(VendaEntity vendaEntity);

    Page<VendaEntity> listarTodasVendas(Pageable paginacao);

}
