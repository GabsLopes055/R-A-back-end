package ra.backend.controllers.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.VendaController;
import ra.backend.entity.DTOs.request.FiltroVendaRequest;
import ra.backend.entity.DTOs.request.VendaRequest;
import ra.backend.entity.DTOs.response.VendaResponse;
import ra.backend.services.VendasService;

@Service
public class VendaControllerImpl implements VendaController {

    @Autowired
    private VendasService service;

    @Override
    public ResponseEntity<VendaResponse> cadastrarVenda(VendaRequest entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarVenda(entity));
    }

    @Override
    public Page<VendaResponse> listarVendas(FiltroVendaRequest filtroBusca) {
        return service.listarTodasVendas(filtroBusca);
    }

    @Override
    public ResponseEntity<?> deletarVenda(String idVenda) {
        service.deletarVenda(idVenda);
        return null;
    }

    @Override
    public ResponseEntity<VendaResponse> buscarVendaPorId(String idVenda) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarVendaPorId(idVenda));
    }

}
