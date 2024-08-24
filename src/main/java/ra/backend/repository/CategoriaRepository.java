package ra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.backend.entity.CategoriaEntity;
import ra.backend.entity.ProdutosEntity;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, String> {

}