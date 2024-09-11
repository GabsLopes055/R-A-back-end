package ra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.backend.entity.VendaEntity;

@Repository
public interface VendasRepository extends JpaRepository<VendaEntity, String> {
}
