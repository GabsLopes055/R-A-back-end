package ra.backend.services.Impl;

import org.springframework.stereotype.Service;
import ra.backend.entity.CategoriaEntity;
import ra.backend.entity.DTOs.request.CategoriaBolsasRequest;
import ra.backend.entity.DTOs.response.CategoriaBolsasResponse;
import ra.backend.repository.CategoriaRepository;
import ra.backend.services.CategoriaService;
import ra.backend.services.exceptions.EntityNaoEncontrada;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoriaBolsasResponse cadastrar(CategoriaBolsasRequest request) {

        CategoriaEntity entity = new CategoriaEntity();

        entity.setNomeCategoria(request.getNomeCategoria());

        repository.save(entity);

        return CategoriaBolsasResponse.toEntity(entity);

    }

    @Override
    public List<CategoriaBolsasResponse> listarTodasCategorias() {

        var listaCategorias = repository.findAll();

        return listaCategorias.stream().map(CategoriaBolsasResponse::toEntity).collect(Collectors.toList());
    }

    @Override
    public CategoriaBolsasResponse editarCategoriaBolsas(String idCategoria, CategoriaBolsasRequest request) {

        Optional<CategoriaEntity> buscarCategoria;

        buscarCategoria = Optional.ofNullable(repository.findById(idCategoria).orElseThrow( () -> new EntityNaoEncontrada("Categoria não encontrada")));

        buscarCategoria.get().setNomeCategoria(request.getNomeCategoria());

        repository.save(buscarCategoria.get());

        return CategoriaBolsasResponse.toEntity(buscarCategoria.get());

    }


}
