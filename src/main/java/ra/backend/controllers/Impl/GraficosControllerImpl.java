package ra.backend.controllers.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.backend.controllers.GraficosController;
import ra.backend.entity.Grafics.GraficoQuantidadeVendidaPorMes;
import ra.backend.services.GraficosService;

import java.util.List;

@Service
public class GraficosControllerImpl implements GraficosController {

    @Autowired
    private GraficosService graficosService;

    @Override
    public ResponseEntity<List<GraficoQuantidadeVendidaPorMes>> buscarQuantidadeVendas() {
        return ResponseEntity.status(HttpStatus.OK).body(graficosService.buscarQuantidadeVendasRealizadas());
    }
}
