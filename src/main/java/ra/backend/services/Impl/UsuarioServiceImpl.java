package ra.backend.services.Impl;

import org.springframework.stereotype.Service;
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

    UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
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
