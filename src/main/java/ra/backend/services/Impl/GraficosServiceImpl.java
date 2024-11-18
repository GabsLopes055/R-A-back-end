package ra.backend.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.backend.entity.Grafics.GraficoQuantidadeVendidaPorMes;
import ra.backend.repository.GraficosRepository;
import ra.backend.repository.VendasRepository;
import ra.backend.services.GraficosService;

import java.util.List;

@Service
public class GraficosServiceImpl implements GraficosService {

    @Autowired
    private GraficosRepository graficosRepository;

    @Override
    public List<GraficoQuantidadeVendidaPorMes> buscarQuantidadeVendasRealizadas() {

        List<Object[]> resultados = graficosRepository.buscarDadosGrafico();

        return resultados.stream()
                .map(result -> new GraficoQuantidadeVendidaPorMes(
                        ((Number) result[0]).intValue(), // ano
                        ((Number) result[1]).intValue(), // mes
                        ((Number) result[2]).longValue() // quantidadeVendas
                ))
                .toList();
    }
}
