package ra.backend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.backend.entity.DTOs.request.AuthenticationRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.AuthenticationResponse;
import ra.backend.entity.DTOs.response.UsuarioResponse;

@RestController
@RequestMapping(value = "/authentication")
public interface AuthenticationController {

    @PostMapping(value = "/login")
    AuthenticationResponse login(@RequestBody AuthenticationRequest request);

    @PostMapping(value = "/register")
    UsuarioResponse registrar(@RequestBody UsuarioRequest usuarioRequest);

}
