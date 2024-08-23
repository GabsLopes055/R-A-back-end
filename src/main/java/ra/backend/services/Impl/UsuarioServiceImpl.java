package ra.backend.services.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;
import ra.backend.repository.UsuarioRepository;
import ra.backend.services.UsuarioService;
import ra.backend.services.exceptions.EmailJaCadastradoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    UsuarioServiceImpl(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.passwordEncoder = encoder;
    }


    @Override
    public Page<UsuarioResponse> listarTodos(FiltroUsuarioRequest request, Pageable pageable) {

        Page<UsuarioEntity> listaUsuarioEntities = repository.listarPorFiltro(request, pageable);

        List<UsuarioResponse> responseDTO = UsuarioResponse.toListResponse(listaUsuarioEntities.getContent());

        return new PageImpl<>(responseDTO, pageable, listaUsuarioEntities.getTotalElements());

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

        return UsuarioResponse.toEntity(usuarioSAlvo);
    }

    @Override
    public void deletarUsuario(String idUsuario) {

    }

    @Override
    public UsuarioResponse editarUsuario(String idUsuario, UsuarioRequest usuarioRequest) {
        return null;
    }
}
