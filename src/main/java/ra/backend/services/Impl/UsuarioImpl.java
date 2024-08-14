package ra.backend.services.Impl;

import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;
import ra.backend.repository.UsuarioRepository;
import ra.backend.services.Usuario;
import ra.backend.services.exceptions.EmailJaCadastrado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioImpl implements Usuario {

    private final UsuarioRepository repository;

    UsuarioImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public UsuarioResponse cadastrar(UsuarioRequest usuarioRequest) {

        Optional<UsuarioEntity> procurarUsuarioJaSalvo = repository.findByEmail(usuarioRequest.getEmail());

        if(procurarUsuarioJaSalvo.isPresent()) {
            throw new EmailJaCadastrado("Email: " + usuarioRequest.getEmail() + " já esta cadastrado");
        }

        UsuarioEntity salvarUsuarioEntity = new UsuarioEntity();

        salvarUsuarioEntity.setNomeCompleto(usuarioRequest.getNomeCompleto());
        salvarUsuarioEntity.setEmail(usuarioRequest.getEmail());
        salvarUsuarioEntity.setPassword(usuarioRequest.getPassword());
        salvarUsuarioEntity.setStatusUsuario(usuarioRequest.getStatusUsuario());
        salvarUsuarioEntity.setPermissao(usuarioRequest.getPermissao());

        var usuarioSAlvo = repository.save(salvarUsuarioEntity);

        return new UsuarioResponse().toEntity(usuarioSAlvo);
    }

    @Override
    public List<UsuarioResponse> listarTodos() {

        List<UsuarioEntity> listaUsuarioEntities;

        listaUsuarioEntities = repository.findAll();

        List<UsuarioResponse> response = new ArrayList<>();

        for(UsuarioEntity retornar : listaUsuarioEntities) {
            response.add(new UsuarioResponse().toEntity(retornar));
        }

        return response;

    }

    @Override
    public void deletarUsuario(String idUsuario) {

    }

    @Override
    public UsuarioResponse editarUsuario(String idUsuario, UsuarioRequest usuarioRequest) {
        return null;
    }
}
