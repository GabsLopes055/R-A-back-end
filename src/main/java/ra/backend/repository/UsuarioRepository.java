package ra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.backend.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    Optional<UsuarioEntity> findByEmail(String email);

}
