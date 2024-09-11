package ra.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.backend.entity.DTOs.request.FiltroProdutoRequest;
import ra.backend.entity.ProdutosEntity;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosEntity, String> {

    @Query(value = "SELECT * FROM tbl_produtos WHERE categoria_id = :idCategoria", nativeQuery = true)
    List<ProdutosEntity> findProdutosByCategoriaId(String idCategoria);

    @Query("""
            SELECT produto FROM ProdutosEntity produto
        WHERE (:#{#filtro.tipoProduto} IS NULL OR LOWER(produto.nomeProduto) LIKE LOWER(CONCAT('%', :#{#filtro.tipoProduto}, '%')))
            """)
    Page<ProdutosEntity> listarPorFiltro(FiltroProdutoRequest filtro, Pageable pageable);


}
//AND (:#{#filtro.role} IS NULL OR usuario.role = :#{#filtro.role})
//AND (:#{#filtro.statusUser} IS NULL OR usuario.status = :#{#filtro.statusUser})