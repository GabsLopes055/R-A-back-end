package ra.backend.services.Impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.AuthenticationRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.AuthenticationResponse;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;
import ra.backend.entity.enums.StatusUser;
import ra.backend.infra.security.TokenService;
import ra.backend.repository.UsuarioRepository;
import ra.backend.services.AuthenticationService;
import ra.backend.services.exceptions.EmailJaCadastradoService;
import ra.backend.services.exceptions.SenhaIncorretaService;
import ra.backend.services.exceptions.UsuarioInativoService;
import ra.backend.services.exceptions.EntityNaoEncontrada;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthenticationServiceImpl(UsuarioRepository repository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {

        UsuarioEntity user = repository.findByEmail(request.getEmail()).orElseThrow(() -> new EntityNaoEncontrada("Usuário não encontrado"));

        AuthenticationResponse response = new AuthenticationResponse();

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            if (user.getStatus() == StatusUser.ATIVO) {

                String token = tokenService.retornaToken(user);
                response.setToken(token);
                response.setUsuario(user.getEmail());

            } else {
                throw new UsuarioInativoService("Seu usuário está inativo");
            }
        } else {
            throw new SenhaIncorretaService("Senha incoreta");
        }

        return response;

    }

    @Override
    public UsuarioResponse cadastrar(UsuarioRequest usuarioRequest) {

        Optional<UsuarioEntity> procurarUsuarioJaSalvo = repository.findByEmail(usuarioRequest.getEmail());

        if (procurarUsuarioJaSalvo.isPresent()) {
            throw new EmailJaCadastradoService("Email: " + usuarioRequest.getEmail() + " já esta cadastrado");
        }

        UsuarioEntity salvarUsuarioEntity = new UsuarioEntity();

        salvarUsuarioEntity.setNomeCompleto(usuarioRequest.getNomeCompleto());
        salvarUsuarioEntity.setEmail(usuarioRequest.getEmail());
        salvarUsuarioEntity.setPassword(passwordEncoder.encode(usuarioRequest.getPassword()));
        salvarUsuarioEntity.setStatus(usuarioRequest.getStatusUsuario());
        salvarUsuarioEntity.setRole(usuarioRequest.getPermissao());

        var usuarioSAlvo = repository.save(salvarUsuarioEntity);

        return new UsuarioResponse().toEntity(usuarioSAlvo);
    }
}
