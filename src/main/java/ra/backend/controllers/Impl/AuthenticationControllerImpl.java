package ra.backend.controllers.Impl;

import org.springframework.stereotype.Service;
import ra.backend.controllers.AuthenticationController;
import ra.backend.entity.DTOs.request.AuthenticationRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.AuthenticationResponse;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.services.AuthenticationService;

@Service
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationControllerImpl(AuthenticationService service) {
        this.authenticationService = service;
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        return authenticationService.login(request);
    }

    @Override
    public UsuarioResponse registrar(UsuarioRequest usuarioRequest) {
        return authenticationService.cadastrar(usuarioRequest);
    }
}
