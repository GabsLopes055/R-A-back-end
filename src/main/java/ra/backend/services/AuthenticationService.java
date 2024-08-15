package ra.backend.services;

import ra.backend.entity.DTOs.request.AuthenticationRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.AuthenticationResponse;
import ra.backend.entity.DTOs.response.UsuarioResponse;

public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);

    UsuarioResponse cadastrar(UsuarioRequest usuarioRequest);
}
