package ra.backend.services;

import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;

import java.util.List;

public interface Usuario {

    UsuarioResponse cadastrar(UsuarioRequest usuarioRequest);

    List<UsuarioResponse> listarTodos();

    void deletarUsuario(String idUsuario);

    UsuarioResponse editarUsuario(String idUsuario, UsuarioRequest usuarioRequest);

}
