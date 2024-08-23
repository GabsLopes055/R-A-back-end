package ra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.backend.entity.CategoriaBolsasEntity;

@Repository
public interface CategoriaBolsasRepository extends JpaRepository<CategoriaBolsasEntity, String> {
}
