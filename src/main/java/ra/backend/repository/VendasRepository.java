package ra.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.backend.entity.VendaEntity;

@Repository
public interface VendasRepository extends JpaRepository<VendaEntity, String> {

    @Query(value = "SELECT * FROM tbl_vendas", nativeQuery = true)
    Page<VendaEntity> listarPorPaginacao(Pageable pageable);


}
