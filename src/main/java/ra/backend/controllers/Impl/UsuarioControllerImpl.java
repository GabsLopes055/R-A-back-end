package ra.backend.controllers.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.controllers.UsuarioController;
import ra.backend.entity.DTOs.request.FiltroUsuarioRequest;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.entity.UsuarioEntity;
import ra.backend.services.UsuarioService;

import java.util.List;

@Service
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioService service;

    @Override
    public Page<UsuarioEntity> listarTodos(FiltroUsuarioRequest request) {

        Pageable pageable = PageRequest.of(request.getPagina() != null ? request.getPagina() : 0, request.getTamanhoPagina() != null ? request.getTamanhoPagina() : 10);

        return service.listarTodos(request, pageable);
    }
}
