package ra.backend.services.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;
import ra.backend.repository.UsuarioRepository;
import ra.backend.services.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Page<UsuarioEntity> listarTodos(FiltroUsuarioRequest request, Pageable pageable) {

        Page<UsuarioEntity> listaUsuarioEntities;

        listaUsuarioEntities = repository.listarPorFiltro(request, pageable);

//        List<UsuarioResponse> response = new ArrayList<>();
//
//        for(List<UsuarioResponse> retornar : listaUsuarioEntities) {
//            response.add(new UsuarioResponse().toEntity((UsuarioEntity) retornar));
//        }
        return listaUsuarioEntities;
//        return (Page<UsuarioResponse>) response;

    }

    @Override
    public void deletarUsuario(String idUsuario) {

    }

    @Override
    public UsuarioResponse editarUsuario(String idUsuario, UsuarioRequest usuarioRequest) {
        return null;
    }
}
