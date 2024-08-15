package ra.backend.services;

import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> listarTodos();

    void deletarUsuario(String idUsuario);

    UsuarioResponse editarUsuario(String idUsuario, UsuarioRequest usuarioRequest);

}
