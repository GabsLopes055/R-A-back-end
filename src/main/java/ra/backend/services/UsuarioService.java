package ra.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    Page<UsuarioEntity> listarTodos(FiltroUsuarioRequest request, Pageable pageable);

    void deletarUsuario(String idUsuario);

    UsuarioResponse editarUsuario(String idUsuario, UsuarioRequest usuarioRequest);

}
