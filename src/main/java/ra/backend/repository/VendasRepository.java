package ra.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.backend.entity.VendaEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface VendasRepository extends JpaRepository<VendaEntity, String> {

    @Query(value = "SELECT * FROM tbl_vendas WHERE DATE(data_venda) BETWEEN TO_DATE(:dataInicio, 'YYYY-MM-DD') AND TO_DATE(:dataFim, 'YYYY-MM-DD');", nativeQuery = true)
    Page<VendaEntity> listarPorPaginacao(Pageable pageable, LocalDate dataInicio, LocalDate dataFim);


}
