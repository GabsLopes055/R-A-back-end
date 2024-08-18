package ra.backend.services.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;
import ra.backend.repository.UsuarioRepository;
import ra.backend.services.UsuarioService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public Page<UsuarioResponse> listarTodos(FiltroUsuarioRequest request, Pageable pageable) {

        Page<UsuarioEntity> listaUsuarioEntities = repository.listarPorFiltro(request, pageable);

        List<UsuarioResponse> responseDTO = UsuarioResponse.toListResponse(listaUsuarioEntities.getContent());

        return new PageImpl<>(responseDTO, pageable, listaUsuarioEntities.getTotalElements());

    }

    @Override
    public void deletarUsuario(String idUsuario) {

    }

    @Override
    public UsuarioResponse editarUsuario(String idUsuario, UsuarioRequest usuarioRequest) {
        return null;
    }
}
