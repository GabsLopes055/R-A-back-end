package ra.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.backend.entity.Grafics.GraficoQuantidadeVendidaPorMes;

import java.util.List;

@RestController
@RequestMapping(value = "/graficos")
public interface GraficosController {

    @GetMapping(value = "/buscarQuantidadeVendas")
    ResponseEntity<List<GraficoQuantidadeVendidaPorMes>> buscarQuantidadeVendas();

}
