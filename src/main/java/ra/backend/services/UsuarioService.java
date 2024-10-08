package ra.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    Page<UsuarioResponse> listarTodos(FiltroUsuarioRequest request, Pageable pageable);

    UsuarioResponse cadastrar(UsuarioRequest request);

    String deletarUsuario(String idUsuario);

    UsuarioResponse editarUsuario(String idUsuario, UsuarioResponse usuarioRequest);

    UsuarioResponse buscarPorId(String idUsuario);

}
