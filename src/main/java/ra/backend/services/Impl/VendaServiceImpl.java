package ra.backend.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.backend.entity.DTOs.request.FiltroBusca;
import ra.backend.entity.VendaEntity;
import ra.backend.repository.VendasRepository;
import ra.backend.services.VendasService;

import java.util.List;

@Service
public class VendaServiceImpl implements VendasService {

    @Autowired
    private VendasRepository repository;

    @Override
    public VendaEntity cadastrarVenda(VendaEntity vendaEntity) {

        return repository.save(vendaEntity);

    }

    @Override
    public Page<VendaEntity> listarTodasVendas(Pageable paginacao) {

        return repository.listarPorPaginacao(paginacao);

    }
}
