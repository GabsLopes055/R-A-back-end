package ra.backend.controllers.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.VendaController;
import ra.backend.entity.VendaEntity;
import ra.backend.services.VendasService;

import java.util.List;

@Service
public class VendaControllerImpl implements VendaController {

    @Autowired
    private VendasService service;

    @Override
    public ResponseEntity<VendaEntity> cadastrarVenda(VendaEntity entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarVenda(entity));
    }

    @Override
    public ResponseEntity<List<VendaEntity>> listarVendas() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodasVendas());
    }

}
