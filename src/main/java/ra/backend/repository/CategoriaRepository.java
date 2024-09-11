package ra.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.backend.entity.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, String> {

    @Query(value = "SELECT * FROM tbl_categorias WHERE id_categoria = :idCategoria", nativeQuery = true)
    CategoriaEntity findByCategoriaById(String idCategoria);

    @Query(value = "SELECT * FROM tbl_categorias", nativeQuery = true)
    Page<CategoriaEntity> listarPaginado(Pageable pageable);
}
