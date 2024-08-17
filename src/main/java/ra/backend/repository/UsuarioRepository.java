package ra.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    Optional<UsuarioEntity> findByEmail(String email);

    @Query("""
        SELECT usuario FROM UsuarioEntity usuario
        WHERE (:#{#filtro.email} IS NULL OR LOWER(usuario.email) LIKE LOWER(CONCAT('%', :#{#filtro.email}, '%')))
          AND (:#{#filtro.nomeCompleto} IS NULL OR LOWER(usuario.nomeCompleto) LIKE LOWER(CONCAT('%', :#{#filtro.nomeCompleto}, '%')))
          AND (:#{#filtro.role} IS NULL OR usuario.role = :#{#filtro.role})
          AND (:#{#filtro.statusUser} IS NULL OR usuario.status = :#{#filtro.statusUser})
       """)
    Page<UsuarioEntity> listarPorFiltro(FiltroUsuarioRequest filtro, Pageable pageable);

}
