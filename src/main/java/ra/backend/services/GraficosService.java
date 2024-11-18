package ra.backend.services;

import ra.backend.entity.Grafics.GraficoQuantidadeVendidaPorMes;

import java.util.List;

public interface GraficosService {

    List<GraficoQuantidadeVendidaPorMes> buscarQuantidadeVendasRealizadas();

}
