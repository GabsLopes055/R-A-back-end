package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.VendaEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public interface VendaController {

    @PostMapping(value = "/cadastrarVenda")
    ResponseEntity<VendaEntity> cadastrarVenda(@RequestBody VendaEntity entity);

    @PostMapping(value = "/listarVendas")
    Page<VendaEntity> listarVendas(@RequestBody FiltroBusca filtroBusca);

}
