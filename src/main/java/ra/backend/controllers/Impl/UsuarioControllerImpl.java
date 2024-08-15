package ra.backend.controllers.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.backend.controllers.UsuarioController;
import ra.backend.entity.DTOs.request.UsuarioRequest;
import ra.backend.entity.DTOs.response.UsuarioResponse;
import ra.backend.services.UsuarioService;

import java.util.List;

@Service
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioService service;

    @Override
    public List<UsuarioResponse> listarTodos() {
        return service.listarTodos();
    }
}
