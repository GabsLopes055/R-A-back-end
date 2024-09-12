package ra.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.backend.entity.VendaEntity;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public interface VendaController {

    @PostMapping(value = "/cadastrarVenda")
    ResponseEntity<VendaEntity> cadastrarVenda(@RequestBody VendaEntity entity);

    @GetMapping(value = "/listarVendas")
    ResponseEntity<List<VendaEntity>> listarVendas();

}
