package ra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ra.backend.entity.Grafics.GraficoQuantidadeVendidaPorMes;
import ra.backend.entity.VendaEntity;

import java.util.List;

public interface GraficosRepository extends JpaRepository<VendaEntity, String> {

    @Query(nativeQuery = true, value = """
                SELECT
                    EXTRACT(YEAR FROM data_venda) AS ano,
                    EXTRACT(MONTH FROM data_venda) AS mes,
                    COUNT(*) AS quantidadeVendas
                FROM tbl_vendas
                GROUP BY 1, 2
                ORDER BY 1 DESC, 2 DESC
            """)
        List<Object[]> buscarDadosGrafico();
}
