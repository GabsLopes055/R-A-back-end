package ra.backend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.DTOs.request.VendaRequest;
import ra.backend.entity.DTOs.response.VendaResponse;
import ra.backend.entity.VendaEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public interface VendaController {

    @PostMapping(value = "/cadastrarVenda")
    ResponseEntity<VendaResponse> cadastrarVenda(@RequestBody VendaRequest entity);

    @PostMapping(value = "/listarVendas")
    Page<VendaResponse> listarVendas(@RequestBody FiltroBusca filtroBusca);

}
