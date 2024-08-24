package ra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.backend.entity.ProdutosEntity;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosEntity, String> {

    @Query(value = "SELECT * FROM tbl_produtos WHERE categoria_id = :idCategoria", nativeQuery = true)
    List<ProdutosEntity> findProdutosByCategoriaId(String idCategoria);
}
