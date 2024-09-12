package ra.backend.services;

import ra.backend.entity.VendaEntity;

import java.util.List;

public interface VendasService {

    VendaEntity cadastrarVenda(VendaEntity vendaEntity);

    List<VendaEntity> listarTodasVendas();

}
